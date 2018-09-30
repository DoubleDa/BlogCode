package com.dyx.wacd;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blankj.utilcode.util.EncryptUtils;
import com.dyx.wacd.constants.Constants;
import com.dyx.wacd.model.MsgModel;
import com.dyx.wacd.utils.AESUtils;
import com.dyx.wacd.utils.DateUtils;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.callback.DataCallback;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.WebSocket;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends Activity {
    @BindView(R.id.et_input)
    EditText etInput;
    @BindView(R.id.btn_send)
    Button btnSend;
    @BindView(R.id.tv_msg)
    TextView tvMsg;
    private Unbinder mUnbinder;
    private List<MsgModel> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        if (mUnbinder != null) {
            mUnbinder.unbind();
        }
        super.onDestroy();
    }

    @OnClick(R.id.btn_send)
    public void onViewClicked() {
        String result = etInput.getText().toString().trim();
        if (!TextUtils.isEmpty(result)) {
            try {
                sengMsg(AESUtils.aesEncrypt(result, Constants.HEX_KEY));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void sengMsg(final String result) {
        AsyncHttpClient.getDefaultInstance().websocket(Constants.WEBSOCKET_HOST, null, new AsyncHttpClient.WebSocketConnectCallback() {
            @Override
            public void onCompleted(Exception ex, WebSocket webSocket) {
                if (ex != null) {
                    ex.printStackTrace();
                    return;
                }
                webSocket.send(result);
                webSocket.send(new byte[10]);
                webSocket.setStringCallback(new WebSocket.StringCallback() {
                    public void onStringAvailable(String s) {
//                        parseResp(s);
//                        Logger.d(s);
                        try {
                            Logger.d(AESUtils.aesDecrypt(s, Constants.HEX_KEY));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                webSocket.setDataCallback(new DataCallback() {
                    public void onDataAvailable(DataEmitter emitter, ByteBufferList byteBufferList) {
                        byteBufferList.recycle();
                    }
                });
            }
        });
    }

    private void parseResp(String s) {
        final MsgModel msgModel = new MsgModel();
        if (s.length() > 10) {
            String time = s.substring(0, 10);
            msgModel.setTime(DateUtils.stampToNewData(time));
        }
        if (s.length() > 19) {
            String channelId = s.substring(11, 19);
            msgModel.setChannelId(channelId);
        }
        if (s.length() > 20) {
            String content = s.substring(20);
            msgModel.setContent(content);
        }
        list.add(msgModel);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvMsg.setText(list.toString());
            }
        });
    }
}

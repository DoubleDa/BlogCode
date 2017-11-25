package com.dyx.ahp;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.widget.Button;

import com.dyx.ahp.model.Person;
import com.dyx.ahp.model.Work;
import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.github.lzyzsd.jsbridge.DefaultHandler;
import com.google.gson.Gson;
import com.mylhyl.acp.Acp;
import com.mylhyl.acp.AcpListener;
import com.mylhyl.acp.AcpOptions;
import com.orhanobut.logger.Logger;

import java.util.List;

public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getName();
    private static final int RESULT_CODE = 0;
    private BridgeWebView mBridgeWebView;
    private Button mButton;
    private ValueCallback<Uri> mUploadMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        //1、初始化BridgeWebView
        mBridgeWebView = findViewById(R.id.bridge_webview);
        mBridgeWebView.setDefaultHandler(new DefaultHandler());
        mBridgeWebView.setWebChromeClient(new WebChromeClient() {
            @SuppressWarnings("unused")
            public void openFileChooser(ValueCallback<Uri> uploadMsg, String AcceptType, String capture) {
                this.openFileChooser(uploadMsg);
            }

            @SuppressWarnings("unused")
            public void openFileChooser(ValueCallback<Uri> uploadMsg, String AcceptType) {
                this.openFileChooser(uploadMsg);
            }

            public void openFileChooser(ValueCallback<Uri> uploadMsg) {
                mUploadMessage = uploadMsg;
                pickFile();
            }
        });
        //2、加载html页面
        mBridgeWebView.loadUrl("file:///android_asset/index.html");
        //3、注册事件(web调用native并传输数据)
        mBridgeWebView.registerHandler("submitFromWeb", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {
                Logger.d(data);
                function.onCallBack("This is registerHandler function!");
            }
        });
        //4、访问事件
        mBridgeWebView.callHandler("functionInJs", getData(), new CallBackFunction() {
            @Override
            public void onCallBack(String data) {
                Logger.d(data);
            }
        });
        //5、添加事件(native调用web并传输数据)
        mButton = findViewById(R.id.btn_java_call_web);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mBridgeWebView.callHandler("functionInJs", getData(), new CallBackFunction() {
                    @Override
                    public void onCallBack(String data) {
                        Logger.d(data);
                    }
                });
            }
        });
        initPermission();
    }

    private void initPermission() {
        Acp.getInstance(this).request(new AcpOptions.Builder().setPermissions(
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.READ_PHONE_STATE).build(), new AcpListener() {
            @Override
            public void onGranted() {
//            getAd(WelcomeAct.this);
//                firstRunInit();
            }

            @Override
            public void onDenied(List<String> permissions) {
//                ToastCheese(permissions.toString() + "权限拒绝");

            }
        });
    }

    private String getData() {
        Person person = new Person();
        Work work = new Work();
        person.setId(0);
        person.setName("dayongxin");
        work.setCompanyName("nb");
        work.setWorkLevel(1);
        work.setWorkNum("001");
        person.setWork(work);
        return new Gson().toJson(person);
    }

    private void pickFile() {
        Intent chooserIntent = new Intent(Intent.ACTION_GET_CONTENT);
        chooserIntent.setType("image/*");
        startActivityForResult(chooserIntent, RESULT_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == RESULT_CODE) {
            if (null == mUploadMessage) {
                return;
            }
            Uri result = intent == null || resultCode != RESULT_OK ? null : intent.getData();
            mUploadMessage.onReceiveValue(result);
            mUploadMessage = null;
        }
    }
}

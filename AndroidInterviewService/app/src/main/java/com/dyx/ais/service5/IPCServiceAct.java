package com.dyx.ais.service5;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.dyx.ais.R;

/**
 * Author：dayongxin
 * Function：
 */
public class IPCServiceAct extends Activity {
    private EditText editText;
    private Button button;
    private TextView textView;
    private IBinder iBinder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iBinder = service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            iBinder = null;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ipc_service);
        initView();
    }

    private void initView() {
        Intent intent = new Intent(this, IPCService.class);
        intent.setAction("com.dyx.ais.service5.IPCService");
        bindService(intent, connection, BIND_AUTO_CREATE);
        editText = findViewById(R.id.et_input);
        button = findViewById(R.id.btn_query);
        textView = findViewById(R.id.tv_show_result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = editText.getText().toString().trim();
                int num = Integer.valueOf(result);
                if (iBinder != null) {
                    android.os.Parcel _data = android.os.Parcel.obtain();
                    android.os.Parcel _reply = android.os.Parcel.obtain();
                    String _result = null;
                    try {
                        _data.writeInterfaceToken("IPCService");
                        _data.writeInt(num);
                        iBinder.transact(0x001, _data, _reply, 0);
                        _reply.readException();
                        _result = _reply.readString();
                        textView.setText(_result);
                        editText.setText("");
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        _reply.recycle();
                        _data.recycle();
                    }
                }
            }
        });
    }
}

package com.dyx.ais.services4;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
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
public class ComplexAIDLAct extends Activity {
    private EditText editText;
    private Button button;
    private TextView textView;
    private ISalary salary;

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            salary = ISalary.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            salary = null;
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complex_aidl);
        initView();
    }

    private void initView() {
        Intent intent = new Intent(this, ComplexAIDLService.class);
        intent.setAction("com.dyx.ais.services4.COMPLEX_AIDL_SERVICE");
        bindService(intent, connection, BIND_AUTO_CREATE);

        editText = findViewById(R.id.et_input);
        button = findViewById(R.id.btn_query);
        textView = findViewById(R.id.tv_show_result);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = editText.getText().toString().trim();
                try {
                    Salary mSalary = salary.getMsg(new User(1, result));
                    textView.setText(result + mSalary.toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }
}

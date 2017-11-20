package com.dyx.ais.service3;

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
import com.dyx.ais.services3.IPerson;

/**
 * Author：dayongxin
 * Function：
 */
public class AIDLAct extends Activity {
    private EditText etInput;
    private Button btnQuery;
    private TextView tvResult;
    private IPerson person;
    private PersonConnection connection = new PersonConnection();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);
        initView();

        Intent intent = new Intent(AIDLAct.this, AIDLService.class);
        intent.setAction("com.dyx.ais.service3.AIDLService");
        bindService(intent, connection, BIND_AUTO_CREATE);
    }

    private void initView() {
        etInput = findViewById(R.id.et_input);
        btnQuery = findViewById(R.id.btn_query);
        tvResult = findViewById(R.id.tv_show_result);
        btnQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = etInput.getText().toString().trim();
                int num = Integer.valueOf(result);
                try {
                    tvResult.setText(person.queryPerson(num));
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                etInput.setText("");
            }
        });
    }

    public class PersonConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            person = IPerson.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            person = null;
        }
    }
}

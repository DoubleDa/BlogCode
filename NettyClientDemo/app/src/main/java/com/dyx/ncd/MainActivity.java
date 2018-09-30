package com.dyx.ncd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dyx.ncd.netty.NettyClient;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.et_address)
    EditText etAddress;
    @BindView(R.id.et_port)
    EditText etPort;
    @BindView(R.id.btn_connect_server)
    Button btnConnectServer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        etAddress.setText("192.168.0.113");
        etPort.setText("8080");
    }


    private void connectServer(String address, int port) {
        new NettyClient().bind(address, port);
    }

    @OnClick({R.id.btn_connect_server})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_connect_server:
                String address = etAddress.getText().toString().trim();
                String port = etPort.getText().toString().trim();
                if (!TextUtils.isEmpty(address) && !TextUtils.isEmpty(port)) {
                    connectServer(address, Integer.valueOf(port));
                } else {
                    Toast.makeText(this, getResources().getString(R.string.str_not_null), Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}

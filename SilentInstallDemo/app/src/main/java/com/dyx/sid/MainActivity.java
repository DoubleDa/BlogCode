package com.dyx.sid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dyx.sid.utils.AppUtils;
import com.dyx.sid.utils.SilentInstallUtils;

public class MainActivity extends AppCompatActivity {
    private Button btnStart;
    private TextView tvVersion;

    private static final String PATH = "/sdcard/new.apk";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        btnStart = findViewById(R.id.btn_install);
        tvVersion = findViewById(R.id.tv_current_version);
        tvVersion.setText(getResources().getString(R.string.str_current_version) + AppUtils.getVersionName(this));
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SilentInstallUtils.execCommand("pm", "install", "-r", PATH);
            }
        });
    }
}

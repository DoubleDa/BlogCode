package com.dyx.va.host;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.didi.virtualapk.PluginManager;
import com.orhanobut.logger.Logger;

import java.io.File;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn_load_native_plugin)
    Button btnLoadNativePlugin;
    @BindView(R.id.btn_send_native)
    Button btnSendNative;
    @BindView(R.id.btn_load_remote_plugin)
    Button btnLoadRemotePlugin;
    @BindView(R.id.btn_send_remote)
    Button btnSendRemote;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnbinder = ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_load_native_plugin, R.id.btn_send_native, R.id.btn_load_remote_plugin, R.id.btn_send_remote})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_load_native_plugin:
                loadNativeApk();
                break;
            case R.id.btn_send_native:
                jumpNativePlugin("com.dyx.va.plugin", "com.dyx.va.plugin.MainActivity");
                break;
            case R.id.btn_load_remote_plugin:
                loadRemoteApk();
                break;
            case R.id.btn_send_remote:
                jumpNativePlugin("", "");
                break;
        }
    }

    private void loadNativeApk() {
        String pluginPath = Environment.getExternalStorageDirectory().getAbsolutePath().concat("/Plugin.apk");
        File plugin = new File(pluginPath);
        if (null == plugin) {
            Logger.d("plugin apk is null!");
        } else {
            try {
                PluginManager.getInstance(this).loadPlugin(plugin);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void loadRemoteApk() {

    }

    private void jumpNativePlugin(String packageName, String className) {
        Intent intent = new Intent();
        intent.setClassName(packageName, className);
        startActivity(intent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}

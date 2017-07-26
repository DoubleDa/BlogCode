package com.dyx.vad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @BindView(R.id.btn_plugin_main)
    Button btnPluginMain;
    @BindView(R.id.btn_plugin_search)
    Button btnPluginSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick({R.id.btn_plugin_main, R.id.btn_plugin_search})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_plugin_main:
                intentTo("com.dyx.vad.plugin.main", "com.dyx.vad.plugin.main.MainActivity", "host_to_main_intent", "这是插件Main");
                break;
            case R.id.btn_plugin_search:
                intentTo("com.dyx.vad.plugin.search", "com.dyx.vad.plugin.search.MainActivity", "host_to_search_intent", "这是插件Search");
                break;
        }
    }

    private void intentTo(String packageName, String classname, String intentKey, String intentValue) {
        Intent intent = new Intent();
        intent.setClassName(packageName, classname);
        Bundle bundle = new Bundle();
        bundle.putString(intentKey, intentValue);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}

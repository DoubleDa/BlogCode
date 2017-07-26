package com.dyx.vad.plugin.search;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;

public class MainActivity extends Activity {
    private static final String HOST_TO_SEARCH_INTENT = "host_to_search_intent";
    private String intentResult;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intentResult = getIntent().getStringExtra(HOST_TO_SEARCH_INTENT);
        initView();
    }

    private void initView() {
        mTextView = (TextView) findViewById(R.id.tv_show_msg);
        if (mTextView != null && !TextUtils.isEmpty(intentResult)) {
            mTextView.setText(intentResult);
        }
    }
}

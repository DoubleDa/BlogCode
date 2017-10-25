package com.dyx.acs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Author：dayongxin
 * Function：
 */
public class ThreeActivity extends AppCompatActivity {
    @BindView(R.id.btn_back)
    Button btnBack;
    @BindView(R.id.ll_root)
    RelativeLayout llRoot;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        ButterKnife.bind(this);
        initBg();
    }

    private void initBg() {
        llRoot.setBackgroundColor(getResources().getColor(XApplication.states));
    }

    @OnClick(R.id.btn_back)
    public void onViewClicked() {
        finish();
    }
}

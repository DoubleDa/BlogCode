package com.dyx.rvid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn_rv_refresh_withme)
    Button btnRvRefreshWithme;
    @BindView(R.id.btn_btn_rv_refresh_with_library)
    Button btnBtnRvRefreshWithLibrary;
    @BindView(R.id.btn_btn_rv_add_header_view)
    Button btnBtnRvAddHeaderView;
    @BindView(R.id.btn_btn_rv_add_foot_view)
    Button btnBtnRvAddFootView;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnbinder = ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_rv_refresh_withme, R.id.btn_btn_rv_refresh_with_library, R.id.btn_btn_rv_add_header_view, R.id.btn_btn_rv_add_foot_view})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_rv_refresh_withme:
                intentTo(RvRefreshWithmeAct.class);
                break;
            case R.id.btn_btn_rv_refresh_with_library:
                intentTo(RvRefreshWithLibraryAct.class);
                break;
            case R.id.btn_btn_rv_add_header_view:
                break;
            case R.id.btn_btn_rv_add_foot_view:
                break;
        }
    }

    private void intentTo(Class<?> cla) {
        startActivity(new Intent(this, cla));
    }
}

package com.dyx.lldd;

import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends BaseActivity {
    @BindView(R.id.btn_show_dialog)
    Button btnShowDialog;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnbinder = ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    @OnClick(R.id.btn_show_dialog)
    public void onViewClicked() {
//        Intent intent = new Intent();
//        intent.setClassName(this, "");
//        startActivity(intent);

        showLoadingDialog(this);
    }
}

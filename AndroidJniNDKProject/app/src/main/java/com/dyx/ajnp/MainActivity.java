package com.dyx.ajnp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.et_write)
    EditText etWrite;
    @BindView(R.id.btn_write)
    Button btnWrite;
    @BindView(R.id.btn_read)
    Button btnRead;
    @BindView(R.id.tv_show_ndk)
    TextView tvShowNdk;
    private Unbinder mUnbinder;

    static {
        System.loadLibrary("my-jni");
    }

    public static native void setText(String msg);

    public static native String getText();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnbinder = ButterKnife.bind(this);
        tvShowNdk.setText(getText());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    @OnClick({R.id.btn_write, R.id.btn_read})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_write:
                if (null != etWrite) {
                    String result = etWrite.getText().toString().trim();
                    if (!TextUtils.isEmpty(result)) {
                        setText(result);
                    }
                }
                break;
            case R.id.btn_read:
                Log.i("MainActivityJni", getText());
                break;
        }
    }
}

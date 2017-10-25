package com.dyx.acs;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.dyx.acs.observer.OneObserver;
import com.dyx.acs.observer.Subject;
import com.dyx.acs.observer.ThreeObserver;
import com.dyx.acs.observer.TwoObserver;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.rb_red)
    RadioButton rbRed;
    @BindView(R.id.rb_blue)
    RadioButton rbBlue;
    @BindView(R.id.rb_green)
    RadioButton rbGreen;
    @BindView(R.id.rb_orange)
    RadioButton rbOrange;
    @BindView(R.id.btn_view_one)
    Button btnViewOne;
    @BindView(R.id.btn_view_two)
    Button btnViewTwo;
    @BindView(R.id.btn_view_three)
    Button btnViewThree;
    @BindView(R.id.rg_root)
    RadioGroup rgRoot;
    private Unbinder mUnbinder;
    private Subject subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUnbinder = ButterKnife.bind(this);
        initView();
        initObserver();
    }

    private void initObserver() {
        subject = new Subject();
        new OneObserver(subject);
        new TwoObserver(subject);
        new ThreeObserver(subject);
    }

    private void initView() {
        rgRoot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.rb_red:
                        subject.setState(R.color.color_red);
                        break;
                    case R.id.rb_blue:
                        subject.setState(R.color.color_blue);
                        break;
                    case R.id.rb_green:
                        subject.setState(R.color.color_green);
                        break;
                    case R.id.rb_orange:
                        subject.setState(R.color.color_orange);
                        break;
                }
            }
        });
    }

    @OnClick({R.id.btn_view_one, R.id.btn_view_two, R.id.btn_view_three})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_view_one:
                intentTo(OneActivity.class);
                break;
            case R.id.btn_view_two:
                intentTo(TwoActivity.class);
                break;
            case R.id.btn_view_three:
                intentTo(ThreeActivity.class);
                break;
        }
    }

    private void intentTo(Class<?> cla) {
        startActivity(new Intent(this, cla));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}

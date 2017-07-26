package com.dyx.gscp.tab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.dyx.gscp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/21 下午3:18
 * alter person：dayongxin
 * alter time：2017/7/21 下午3:18
 * alter remark：
 */
public class TabActivity extends FragmentActivity {
    @BindView(R.id.btn_left)
    Button btnLeft;
    @BindView(R.id.btn_right)
    Button btnRight;
    @BindView(R.id.container)
    FrameLayout container;
    @BindView(R.id.tv_bottom)
    TextView tvBottom;
    private Unbinder mUnbinder;

    private FragmentA fragmentA;
    private FragmentB fragmentB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        mUnbinder = ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        setSelected(0);
    }

    private void setSelected(int index) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        hideFragment(transaction);

        switch (index) {
            case 0:
                if (fragmentA == null) {
                    fragmentA = new FragmentA();
                    transaction.add(R.id.container, fragmentA);
                } else {
                    transaction.show(fragmentA);
                }
                break;
            case 1:
                if (fragmentB == null) {
                    fragmentB = new FragmentB();
                    transaction.add(R.id.container, fragmentB);
                } else {
                    transaction.show(fragmentB);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }

    private void hideFragment(FragmentTransaction transaction) {
        if (fragmentA != null) {
            transaction.hide(fragmentA);
        }

        if (fragmentB != null) {
            transaction.hide(fragmentB);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }

    @OnClick({R.id.btn_left, R.id.btn_right})
    public void onViewClicked(View view) {
        resetImage();
        switch (view.getId()) {
            case R.id.btn_left:
                setSelected(0);
                break;
            case R.id.btn_right:
                setSelected(1);
                break;
        }
    }

    private void resetImage() {
        btnLeft.setBackgroundResource(R.mipmap.ic_launcher);
        btnRight.setBackgroundResource(R.mipmap.ic_launcher);
    }
}

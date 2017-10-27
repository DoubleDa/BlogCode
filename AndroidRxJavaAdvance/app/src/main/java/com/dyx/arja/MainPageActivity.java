package com.dyx.arja;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.dyx.arja.fragment.RxBusFragment;
import com.dyx.arja.fragment.RxLifecycleFragment;
import com.dyx.arja.fragment.RxOkhttpFragment;
import com.dyx.arja.fragment.RxRepAsyncFragment;
import com.dyx.arja.fragment.RxRetrofitFragment;

public class MainPageActivity extends AppCompatActivity {
    private RxRepAsyncFragment mRxRepAsyncFragment;
    private RxOkhttpFragment mRxOkhttpFragment;
    private RxRetrofitFragment mRxRetrofitFragment;
    private RxBusFragment mRxBusFragment;
    private RxLifecycleFragment mRxLifecycleFragment;
    private FragmentManager mFragmentManager;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentTransaction ft = mFragmentManager.beginTransaction();
            hideAllFragment(ft);
            switch (item.getItemId()) {
                case R.id.na_rx_rp_as:
                    if (mRxRepAsyncFragment == null) {
                        mRxRepAsyncFragment = new RxRepAsyncFragment();
                        ft.add(R.id.content, mRxRepAsyncFragment);
                    } else {
                        ft.show(mRxRepAsyncFragment);
                    }
                    ft.commit();
                    return true;
                case R.id.na_rx_okhttp:
                    if (mRxOkhttpFragment == null) {
                        mRxOkhttpFragment = new RxOkhttpFragment();
                        ft.add(R.id.content, mRxOkhttpFragment);
                    } else {
                        ft.show(mRxOkhttpFragment);
                    }
                    ft.commit();
                    return true;
                case R.id.na_rx_retrofit:
                    if (mRxRetrofitFragment == null) {
                        mRxRetrofitFragment = new RxRetrofitFragment();
                        ft.add(R.id.content, mRxRetrofitFragment);
                    } else {
                        ft.show(mRxRetrofitFragment);
                    }
                    ft.commit();
                    return true;
                case R.id.na_rxbus:
                    if (mRxBusFragment == null) {
                        mRxBusFragment = new RxBusFragment();
                        ft.add(R.id.content, mRxBusFragment);
                    } else {
                        ft.show(mRxBusFragment);
                    }
                    ft.commit();
                    return true;
                case R.id.na_rxlifecycle:
                    if (mRxLifecycleFragment == null) {
                        mRxLifecycleFragment = new RxLifecycleFragment();
                        ft.add(R.id.content, mRxLifecycleFragment);
                    } else {
                        ft.show(mRxLifecycleFragment);
                    }
                    ft.commit();
                    return true;
            }
            return false;
        }

    };

    private void hideAllFragment(FragmentTransaction ft) {
        if (mRxRepAsyncFragment != null) {
            ft.hide(mRxRepAsyncFragment);
        }
        if (mRxOkhttpFragment != null) {
            ft.hide(mRxOkhttpFragment);
        }
        if (mRxRetrofitFragment != null) {
            ft.hide(mRxRetrofitFragment);
        }
        if (mRxBusFragment != null) {
            ft.hide(mRxBusFragment);
        }
        if (mRxLifecycleFragment != null) {
            ft.hide(mRxLifecycleFragment);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        mFragmentManager = getSupportFragmentManager();
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initView();
    }

    private void initView() {
        FragmentTransaction ft = mFragmentManager.beginTransaction();
        if (mRxRepAsyncFragment == null) {
            mRxRepAsyncFragment = new RxRepAsyncFragment();
            ft.add(R.id.content, mRxRepAsyncFragment);
        } else {
            ft.show(mRxRepAsyncFragment);
        }
        ft.commit();
    }

}

package com.dyx.aa.mvvm;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.dyx.aa.R;
import com.dyx.aa.databinding.ActivityMvvmBinding;
import com.dyx.aa.mvvm.model.Person;

/**
 * Author：dayongxin
 * Function：
 */
public class MVVMActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMvvmBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        Person person = new Person("dayongxin", "18");
        binding.setPerson(person);
        /**
         * 添加点击事件1
         */
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        /**
         * 添加点击事件2
         */
        binding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}

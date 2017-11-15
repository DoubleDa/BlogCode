package com.dyx.aa.mvvm;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dyx.aa.R;
import com.dyx.aa.databinding.ActivityMvvmOtherBinding;

/**
 * Author：dayongxin
 * Function：
 */
public class MVVMOtherAct extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMvvmOtherBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_other);
        binding.setName("dayongxin");
        binding.setAge(18);
        binding.setMan(true);
    }
}

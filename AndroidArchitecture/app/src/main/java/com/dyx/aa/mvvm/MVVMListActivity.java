package com.dyx.aa.mvvm;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dyx.aa.R;
import com.dyx.aa.databinding.ActivityMvvmListBinding;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Author：dayongxin
 * Function：
 */
public class MVVMListActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMvvmListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_list);
        /**
         * 添加ArrayList数据源
         */
        ArrayList<String> list = new ArrayList<>();
        list.add("dyx");
        list.add("abc");
        list.add("ghu");
        binding.setList(list);
        /**
         * 添加HashMap数据源
         */
        Map<String, String> map = new HashMap();
        map.put("age", "18");
        binding.setMap(map);
        /**
         * 添加Array数据源
         */
        String[] arrays = {"A", "B", "C"};
        binding.setArrays(arrays);
    }
}

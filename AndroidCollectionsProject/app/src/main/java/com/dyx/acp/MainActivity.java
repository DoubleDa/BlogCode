package com.dyx.acp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.util.SparseLongArray;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        /**
         * 1、无参数构造方法
         */
        noParamsSparseArray();
        /**
         * 2、HashMap
         */
        itsHashMap();
        /**
         * 3、ArrayList
         */
        itsList();
        /**
         * 4、
         */
        itsLLL();
    }

    private void itsLLL() {
    }

    private void itsList() {
        List<String> list=new ArrayList<>();
    }

    private void itsHashMap() {
        Map<String, Object> map = new HashMap<>();
    }

    private void noParamsSparseArray() {
        /**
         * 1
         */
        SparseArray<View> array = new SparseArray<>();
        /**
         * 2
         */
        SparseArray<Integer> integerSparseArray = new SparseArray<>();
        SparseIntArray intArray = new SparseIntArray();
        /**
         * 3
         */
        SparseArray<Boolean> booleanSparseArray = new SparseArray<>();
        SparseBooleanArray booleanArray = new SparseBooleanArray();
        /**
         * 4
         */
        SparseArray<Long> longSparseArray = new SparseArray<>();
        SparseLongArray longArray = new SparseLongArray();
    }
}

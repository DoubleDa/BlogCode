package com.dyx.rvid;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.dyx.rvid.adapter.MyRvAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler;
import in.srain.cube.views.ptr.PtrFrameLayout;
import in.srain.cube.views.ptr.PtrHandler;

/**
 * Author：dayongxin
 * Function：
 */
public class RvRefreshWithLibraryAct extends Activity {
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.ptr_classic_frame_layout)
    PtrClassicFrameLayout ptrClassicFrameLayout;
    private Unbinder mUnbinder;
    private MyRvAdapter mMyRvAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_refresh_with_library_layout);
        mUnbinder = ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mMyRvAdapter = new MyRvAdapter(this, getDatas());
        recyclerView.setAdapter(mMyRvAdapter);
        /**
         * 1、设置PtrClassicFrameLayout
         */
        // the following are default settings
        ptrClassicFrameLayout.setResistance(1.7f);
        ptrClassicFrameLayout.setRatioOfHeaderHeightToRefresh(1.2f);
        ptrClassicFrameLayout.setDurationToClose(200);
        ptrClassicFrameLayout.setDurationToCloseHeader(1000);
        // default is false
        ptrClassicFrameLayout.setPullToRefresh(false);
        // default is true
        ptrClassicFrameLayout.setKeepHeaderWhenRefresh(true);
        /**
         * 2、为PtrClassicFrameLayout设置刷新监听
         */
        ptrClassicFrameLayout.setPtrHandler(new PtrHandler() {
            /**
             *
             * @param frame
             * @param content
             * @param header
             * @return 检查是否可以执行下来刷新
             */
            @Override
            public boolean checkCanDoRefresh(PtrFrameLayout frame, View content, View header) {
                return PtrDefaultHandler.checkContentCanBePulledDown(frame, content, header);
            }

            /**
             * @function 需要加载数据时触发
             * @param frame
             */
            @Override
            public void onRefreshBegin(PtrFrameLayout frame) {
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ptrClassicFrameLayout.refreshComplete();
                    }
                }, 2000);
            }
        });
        /**
         * 3、自定义刷新头部
         */
    }

    private List<String> getDatas() {
        List<String> results = new ArrayList<>();
        for (int i = 0; i < 49; i++) {
            results.add("条目：" + String.valueOf(i));
        }
        return results;
    }
}

package com.dyx.rvid;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.dyx.rvid.adapter.MyRvAdapter;
import com.dyx.rvid.listener.EndlessRecyclerViewScrollListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author：dayongxin
 * Function：
 */
public class RvRefreshWithmeAct extends Activity {
    private static final String TAG = "RvRefreshWithmeAct";
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_refresh_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private Unbinder mUnbinder;
    private MyRvAdapter mMyRvAdapter;
    private int pageIndex = 1;
    private EndlessRecyclerViewScrollListener scrollListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_refresh_withme_layout);
        mUnbinder = ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        recyclerView.setLayoutFrozen(true);
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(manager);
        mMyRvAdapter = new MyRvAdapter(this, getDatas(pageIndex));
        recyclerView.setAdapter(mMyRvAdapter);
        //1、设置刷新监听
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getDataFromServer(pageIndex++);
            }
        });
        //2、配置刷新视图颜色
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        //3、加载更多
        scrollListener = new EndlessRecyclerViewScrollListener(manager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                Log.i(TAG, "***onLoadMore***");
                if (mMyRvAdapter != null) {
                    int curSize=mMyRvAdapter.getItemCount();
                    mMyRvAdapter.addAll(getDatas(page++));
//                    mMyRvAdapter.notifyItemRangeInserted(curSize,);
                }
            }
        };
        recyclerView.addOnScrollListener(scrollListener);
    }

    private List<String> getDatas(int pageIndex) {
        List<String> results = new ArrayList<>();
        for (int i = pageIndex; i < pageIndex + 32; i++) {
            results.add("条目：" + String.valueOf(i));
        }
        return results;
    }

    private void getDataFromServer(int index) {
        //3、获取数据并进行列表数据更新
        if (mMyRvAdapter != null) {
            mMyRvAdapter.clear();
            mMyRvAdapter.addAll(getDatas(index));
            swipeRefreshLayout.setRefreshing(false);
        }
    }
}

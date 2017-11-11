package com.dyx.rvap;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.ames.uncover.UncoveringDataModel;
import com.ames.uncover.primary.PrimaryDataProvider;
import com.ames.uncover.primary.PrimaryRequest;
import com.ames.uncover.primary.PrimaryResponse;
import com.dyx.rvap.adapter.PersonAdapter;
import com.dyx.rvap.listener.EndlessRecyclerViewScrollListener;
import com.dyx.rvap.listener.OnItemClickListener;
import com.dyx.rvap.listener.RecyclerViewSwipeListener;
import com.dyx.rvap.model.Person;
import com.dyx.rvap.view.ItemClickSupport;
import com.dyx.rvap.view.SnappyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Author：dayongxin
 * Function：
 */
public class PersonActivity extends Activity {
    private RecyclerView mRecyclerView;
    private PersonAdapter mPersonAdapter;
    private EndlessRecyclerViewScrollListener scrollListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        initView();
    }

    private void initView() {
        mRecyclerView = findViewById(R.id.recycler_view);
        mPersonAdapter = new PersonAdapter(this, getDatas());
        //0、设置LayoutManager
        StaggeredGridLayoutManager gridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        //1、设置LayoutManager
        LinearLayoutManager manager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(manager);
        //2、优化;
        mRecyclerView.setHasFixedSize(true);
        //3、设置动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        //4、设置分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
        //5、设置适配器
        mRecyclerView.setAdapter(mPersonAdapter);
        //6、通知适配器
        mPersonAdapter.notifyDataSetChanged();
        //7、顶部插入&&并停在顶部
        mPersonAdapter.notifyItemInserted(0);
        mRecyclerView.scrollToPosition(0);
        //8、底部插入滑倒底部
        mPersonAdapter.notifyItemInserted(getDatas().size() - 1);
        mRecyclerView.smoothScrollToPosition(mPersonAdapter.getItemCount() - 1);
        //9、设置ScrollListener
        scrollListener = new EndlessRecyclerViewScrollListener(manager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount) {
                loadMoreData(page);
            }
        };
        mRecyclerView.addOnScrollListener(scrollListener);
        //10、自定义动画
        mRecyclerView.setItemAnimator(new SlideInUpAnimator());
        //11、处理点击事件
        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
        //12、LinearSnapHelper
        SnapHelper snapHelper = new LinearSnapHelper();
        snapHelper.attachToRecyclerView(mRecyclerView);
        //13、SnappyRecyclerView
        SnappyRecyclerView snappyRecyclerView = new SnappyRecyclerView(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        snappyRecyclerView.setLayoutManager(linearLayoutManager);
        //14、通过装饰器绑定点击事件
        ItemClickSupport.addTo(mRecyclerView).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                //...
            }
        });
        //15、通过适配器获取点击事件
        mPersonAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(View view, int pos) {

            }

            @Override
            public void onItemLongClick(View view, int pos) {

            }
        });
        //16、检测滑动
        mRecyclerView.setOnFlingListener(new RecyclerViewSwipeListener(true) {
            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
            }

            @Override
            public void onSwipeUp() {
                super.onSwipeUp();
            }

            @Override
            public void onSwipeDown() {
                super.onSwipeDown();
            }
        });
        //17、使用uncover
        final UncoveringDataModel<String> model = new UncoveringDataModel<>();
        model.setPrimaryDataProvider(new PrimaryDataProvider<String>() {
            @Override
            public PrimaryResponse fetch(PrimaryRequest primaryRequest) {
                ArrayList<String> data = new ArrayList<String>();
                return new PrimaryResponse<String>(data, Integer.MAX_VALUE);
            }
        });
        RecyclerView.Adapter adapter = new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return null;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

            }

            @Override
            public int getItemCount() {
                return model.size();
            }
        };
        model.install(mRecyclerView, adapter);
    }

    private void loadMoreData(int page) {
        //...
    }

    private List<Person> getDatas() {
        List<Person> results = new ArrayList<>();
        results.add(new Person("dayongxin", 18, "company", "cqupt", false));
        results.add(new Person("dyx", 18, "company", "cqupt", true));
        results.add(new Person("mimi", 28, "abc", "cqupt", false));
        results.add(new Person("haha", 18, "company", "cqupt", true));
        results.add(new Person("heihei", 18, "company", "cqupt", false));
        results.add(new Person("hehe", 18, "company", "cqupt", false));
        results.add(new Person("yinyin", 18, "company", "cqupt", true));
        results.add(new Person("huhu", 18, "company", "cqupt", false));
        results.add(new Person("lala", 18, "company", "cqupt", true));
        results.add(new Person("xixi", 18, "company", "cqupt", false));
        results.add(new Person("gege", 18, "company", "cqupt", true));
        results.add(new Person("mingming", 18, "company", "cqupt", false));
        return results;
    }
}

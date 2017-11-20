package com.dyx.rvid.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dyx.rvid.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Author：dayongxin
 * Function：
 */
public class MyRvAdapter extends RecyclerView.Adapter<MyRvAdapter.VhMe> {
    private Context mContext;
    private List<String> mDatas;

    public MyRvAdapter(Context mContext, List<String> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @Override
    public VhMe onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_layout, parent, false);
        return new VhMe(view);
    }

    @Override
    public void onBindViewHolder(VhMe holder, int position) {
        holder.textView.setText(mDatas.get(position));
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void clear() {
        mDatas.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<String> datas) {
        mDatas.addAll(datas);
        notifyDataSetChanged();
    }

    public static class VhMe extends RecyclerView.ViewHolder {
        @BindView(R.id.text_view)
        TextView textView;

        public VhMe(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}

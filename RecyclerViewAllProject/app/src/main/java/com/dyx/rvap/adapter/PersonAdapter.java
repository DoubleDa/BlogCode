package com.dyx.rvap.adapter;

import android.content.Context;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.dyx.rvap.R;
import com.dyx.rvap.callback.PersonDiffCallback;
import com.dyx.rvap.listener.OnItemClickListener;
import com.dyx.rvap.model.Person;

import java.util.List;

/**
 * Author：dayongxin
 * Function：
 */
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.RvViewHolder> {
    private Context mContext;
    private List<Person> mDatas;
    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public PersonAdapter(Context mContext, List<Person> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @Override
    public RvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.rv_item_person, parent, false);
        RvViewHolder holder = new RvViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final RvViewHolder holder, final int position) {
        Person person = mDatas.get(position);
        holder.textView.setText(person.getName());
        holder.button.setEnabled(person.isOnline());
        holder.button.setText(person.isOnline() ? "OnLine" : "OffLine");
        if (onItemClickListener != null) {
            /**
             * 为条目添加
             */
            //点击事件
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(holder.itemView, position);
                }
            });
            //长按事件
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onItemClickListener.onItemLongClick(holder.itemView, position);
                    return false;
                }
            });
            /**
             * 为按钮添加
             */
            //点击事件
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(holder.button, position);
                }
            });
            //长按事件
            holder.button.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    onItemClickListener.onItemLongClick(holder.button, position);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void swapItems(List<Person> persons) {
        //1、计算diff
        PersonDiffCallback callback = new PersonDiffCallback(this.mDatas, persons);
        DiffUtil.DiffResult result = DiffUtil.calculateDiff(callback);
        //2、清除数据重新添加
        this.mDatas.clear();
        this.mDatas.addAll(persons);
        //3、diff计算完成之后访问适配器的通知方法
        result.dispatchUpdatesTo(this);
    }

    public  class RvViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView textView;
        public Button button;

        public RvViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_person);
            button = itemView.findViewById(R.id.btn_send);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Person person=mDatas.get(position);
                //...
            }
        }
    }
}

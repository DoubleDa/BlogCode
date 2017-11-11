package com.dyx.rvap.animator;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;
import android.view.animation.BounceInterpolator;

import com.dyx.rvap.R;

/**
 * Author：dayongxin
 * Function：
 */
public class ItemAnimator extends SimpleItemAnimator {
    private Context mContext;

    public ItemAnimator(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public boolean animateRemove(RecyclerView.ViewHolder holder) {
        return false;
    }

    @Override
    public boolean animateAdd(RecyclerView.ViewHolder holder) {
        Animator set = AnimatorInflater.loadAnimator(mContext,
                R.animator.zoom_in);
        set.setInterpolator(new BounceInterpolator());
        set.setTarget(holder.itemView);
        set.start();

        return true;
    }

    @Override
    public boolean animateMove(RecyclerView.ViewHolder holder, int fromX, int fromY, int toX, int toY) {
        return false;
    }

    @Override
    public boolean animateChange(RecyclerView.ViewHolder oldHolder, RecyclerView.ViewHolder newHolder, int fromLeft, int fromTop, int toLeft, int toTop) {
        return false;
    }

    @Override
    public void runPendingAnimations() {

    }

    @Override
    public void endAnimation(RecyclerView.ViewHolder item) {

    }

    @Override
    public void endAnimations() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }
}

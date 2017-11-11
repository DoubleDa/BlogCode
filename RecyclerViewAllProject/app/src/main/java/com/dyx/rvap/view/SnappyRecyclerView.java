package com.dyx.rvap.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Author：dayongxin
 * Function：
 */
public class SnappyRecyclerView extends RecyclerView {
    public SnappyRecyclerView(Context context) {
        super(context);
    }

    public SnappyRecyclerView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SnappyRecyclerView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean fling(int velocityX, int velocityY) {
        final LayoutManager lm = getLayoutManager();
        if (lm instanceof Snappable) {

            super.smoothScrollToPosition(((Snappable) getLayoutManager()).getPositionForVelocity(velocityX, velocityY));
            return true;
        }
        return super.fling(velocityX, velocityY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        final boolean ret = super.onTouchEvent(e);
        final LayoutManager lm = getLayoutManager();
        if (lm instanceof Snappable
                && (e.getAction() == MotionEvent.ACTION_UP ||
                e.getAction() == MotionEvent.ACTION_CANCEL)
                && getScrollState() == SCROLL_STATE_IDLE) {
            smoothScrollToPosition(((Snappable) lm).getFixScrollPos());
        }
        return ret;
    }

    public interface Snappable {
        int getPositionForVelocity(int velocityX, int velocityY);
        int getFixScrollPos();
    }

}

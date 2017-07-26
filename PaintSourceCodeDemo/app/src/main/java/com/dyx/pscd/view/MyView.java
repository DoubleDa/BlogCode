package com.dyx.pscd.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * project name：PaintSourceCodeDemo
 * class describe：
 * create person：dayongxin
 * create time：2017/7/18 下午3:32
 * alter person：dayongxin
 * alter time：2017/7/18 下午3:32
 * alter remark：
 */
public class MyView extends View {
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //将画布涂为白色
        canvas.drawColor(Color.WHITE);
        //创建画笔
        Paint mPaint = new Paint();
        //去锯齿
        mPaint.setAntiAlias(true);
        //设置画笔颜色
        mPaint.setColor(Color.BLUE);
        //设置风格
        mPaint.setStyle(Paint.Style.STROKE);
        //设置画笔宽度
        mPaint.setStrokeWidth(3);
        //绘制圆形
        canvas.drawCircle(60, 60, 50, mPaint);
        //绘制正方形
        canvas.drawRect(70, 140, 140, 210, mPaint);
        //绘制矩形
        //canvas.drawRect(10, 220, 220, 300, mPaint);
        //创建RectF
        RectF mRectF = new RectF(10, 220, 220, 300);
        //创建圆形矩形
        canvas.drawRoundRect(mRectF, 15, 15, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}

package com.menst_verstka.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Alexander on 29.08.13.
 */
public class rotateTextView extends TextView {
    private static final int angle = -90;
    public rotateTextView(Context context) {
        super(context);
    }

    public rotateTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public rotateTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        canvas.rotate(angle,this.getWidth() /2f,this.getHeight() /2f);
        super.onDraw(canvas);
        canvas.restore();
    }
}

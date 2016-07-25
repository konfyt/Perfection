package com.konfyt.perfection.customview;

import android.content.Context;
import android.view.View;

/**
 * Created by Konfyt on 2016/7/24.
 */
public class A extends View {
    public A(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}

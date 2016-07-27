package com.konfyt.perfection.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.GridView;

/**
 * Created by Konfyt on 2016/7/27.
 */
public class NoScrollGirdView extends GridView{
    public NoScrollGirdView(Context context) {
        super(context);
    }

    public NoScrollGirdView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoScrollGirdView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}

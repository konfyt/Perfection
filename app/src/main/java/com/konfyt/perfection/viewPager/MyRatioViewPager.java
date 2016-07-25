package com.konfyt.perfection.viewPager;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
/**
 * Created by XCQ on 16/7/20.
 */
public class MyRatioViewPager extends ViewPager{

    public MyRatioViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRatioViewPager(Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int size = (int) (MeasureSpec.getSize(widthMeasureSpec)/1.1);//这里可以设置viewpager两侧显示的大小
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        widthMeasureSpec = MeasureSpec.makeMeasureSpec(size, mode);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}

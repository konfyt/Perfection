package com.konfyt.perfection.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Toast;

import java.util.List;

/**
 * Created by Konfyt on 2016/7/19.
 * Home页面第一行循环图片ViewPager的适配器
 */
public class EveryPageAdapter extends FragmentPagerAdapter{
    private  List<Fragment> mFragmentList;

    public EveryPageAdapter(List<Fragment> mFragmentList,FragmentManager fm) {
        super(fm);
        this.mFragmentList = mFragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList==null?0:mFragmentList.size();
    }


}

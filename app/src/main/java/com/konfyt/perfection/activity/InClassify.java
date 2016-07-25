package com.konfyt.perfection.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;

import com.konfyt.perfection.R;
import com.konfyt.perfection.customview.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import layout.InFragment;

public class InClassify extends AppCompatActivity {

    private List<Fragment> mList;
    private List<String> titles;
    private TabLayout mTabLayout;
    private NoScrollViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_classify);


        String mPath = getIntent().getStringExtra("path");
        String mCat_id = getIntent().getStringExtra("cat_id");
        initView();
        initListFragements(mPath,mCat_id);

        MyAdapter mAdapter = new MyAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

    }

    private void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.fragment_inClassify_tablayout);
        mViewPager = (NoScrollViewPager) findViewById(R.id.fragment_inClassify_viewpager);
    }

    private void initListFragements(String s1,String s2) {
        mList = new ArrayList<>();
        mList.add(InFragment.newInstance(s1,s2));
        mList.add(InFragment.newInstance(s1,s2));
        mList.add(InFragment.newInstance(s1,s2));
        titles = new ArrayList<>();
        titles.add("最新");
        titles.add("销量");
        titles.add("价格");
    }



    class MyAdapter extends FragmentPagerAdapter{

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mList.get(position);
        }

        @Override
        public int getCount() {
            return mList==null?0:mList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }
}

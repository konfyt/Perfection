package com.konfyt.perfection.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.konfyt.perfection.R;
import com.konfyt.perfection.customview.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import com.konfyt.perfection.fragment.InFragment;

public class InClassify extends AppCompatActivity {

    private List<Fragment> mList;
    private List<String> titles;
    private LinearLayout mLayout;
    private FrameLayout mFrameLayout;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_classify);
        initView();

        String mPath = getIntent().getStringExtra("path");
        String mCat_id = getIntent().getStringExtra("cat_id");
        String mTitle = getIntent().getStringExtra("title");

        tv.setText(mTitle);


    }



    private void initView() {
        mLayout = (LinearLayout) findViewById(R.id.classify_layout);
        mFrameLayout = (FrameLayout) findViewById(R.id.fragment_inClassify_layout);
        tv = (TextView) findViewById(R.id.in_classify_title);
    }

    private void initListFragements(String s1,String s2) {
        mList = new ArrayList<>();
        mList.add(InFragment.newInstance(s1,s2,"1","0"));
        mList.add(InFragment.newInstance(s1,s2,"2","0"));
        mList.add(InFragment.newInstance(s1,s2,"3","4"));

    }




}

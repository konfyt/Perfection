package com.konfyt.perfection.activity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.konfyt.perfection.R;
import com.konfyt.perfection.customview.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import com.konfyt.perfection.fragment.HomePageFragment;
import com.konfyt.perfection.fragment.InFragment;

public class InClassify extends AppCompatActivity implements View.OnClickListener {

    private ImageView img;
    private List<Fragment> mList;
    private List<String> titles;
    private LinearLayout mLayout;
    private FrameLayout mFrameLayout;
    private InFragment fragement1;
    private InFragment fragement2;
    private InFragment fragement3;
    private InFragment fragement4;
    private TextView tv;
    private Button tv1;
    private Button tv2;
    private Button tv3;
    private FragmentManager mManager;
    String mPath;
    String mCat_id;
    private int tag=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_classify);
        initView();
        mManager = getSupportFragmentManager();
        mPath = getIntent().getStringExtra("path");
        mCat_id = getIntent().getStringExtra("cat_id");
        String mTitle = getIntent().getStringExtra("title");
        tv.setText(mTitle);
        if (fragement1 == null) {
            fragement1 = InFragment.newInstance(mPath,mCat_id,"1");
        }
        mManager.beginTransaction().add(R.id.fragment_inClassify_layout,fragement1).commit();
        tv1.setTextColor(Color.RED);
        tv1.setOnClickListener(this);
        tv2.setOnClickListener(this);
        tv3.setOnClickListener(this);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }



    private void initView() {
        mLayout = (LinearLayout) findViewById(R.id.classify_layout);
        mFrameLayout = (FrameLayout) findViewById(R.id.fragment_inClassify_layout);
        tv = (TextView) findViewById(R.id.in_classify_title);
        tv1 = (Button) findViewById(R.id.tv1);
        tv2 = (Button) findViewById(R.id.tv2);
        tv3 = (Button) findViewById(R.id.tv3);
        img = (ImageView) findViewById(R.id.in_classify_back);
    }


    @Override
    public void onClick(View view) {
        FragmentTransaction mTransaction = mManager.beginTransaction();
        hide(mTransaction);
        tv1.setTextColor(Color.GRAY);
        tv2.setTextColor(Color.GRAY);
        tv3.setTextColor(Color.GRAY);
        Drawable drawable= getResources().getDrawable(R.mipmap.price_middle);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tv3.setCompoundDrawables(null,null,drawable,null);
        switch (view.getId()){

            case R.id.tv1:
                if (fragement1!=null&&fragement1.isAdded()){
                    mTransaction.show(fragement1);
                    tv.setTextColor(Color.RED);

                }else {
                    fragement1 = InFragment.newInstance(mPath,mCat_id,"1");
                    mTransaction.add(R.id.fragment_inClassify_layout,fragement1);
                }
                if(tag==2)tag=1;
                else if(tag==1) tag=2;
                tv1.setTextColor(Color.RED);
                break;
            case R.id.tv2:
                if (fragement2!=null&&fragement2.isAdded()){
                    mTransaction.show(fragement2);
                    tv.setTextColor(Color.RED);
                }else {
                    fragement2 = InFragment.newInstance(mPath,mCat_id,"2");
                    mTransaction.add(R.id.fragment_inClassify_layout,fragement2);
                }
                tv2.setTextColor(Color.RED);
                if(tag==2)tag=1;
                else if(tag==1) tag=2;
                break;
            case R.id.tv3:
                if(tag==1){
                    if (fragement3!=null&&fragement3.isAdded()){
                        mTransaction.show(fragement3);
                        tv.setTextColor(Color.RED);
                    }else {
                        fragement3 = InFragment.newInstance(mPath,mCat_id,"3");
                        mTransaction.add(R.id.fragment_inClassify_layout,fragement3);
                    }
                    tag=2;
                    Drawable drawable1= getResources().getDrawable(R.mipmap.price_bottom);
                    drawable1.setBounds(0, 0, drawable1.getMinimumWidth(), drawable1.getMinimumHeight());
                    tv3.setCompoundDrawables(null,null,drawable1,null);
                }else if(tag==2){
                    if (fragement4!=null&&fragement4.isAdded()){
                        mTransaction.show(fragement4);
                        tv.setTextColor(Color.RED);
                    }else {
                        fragement4 = InFragment.newInstance(mPath,mCat_id,"4");
                        mTransaction.add(R.id.fragment_inClassify_layout,fragement4);
                    }
                    tag=1;
                    Drawable drawable2= getResources().getDrawable(R.mipmap.price_top);
                    drawable2.setBounds(0, 0, drawable2.getMinimumWidth(), drawable2.getMinimumHeight());
                    tv3.setCompoundDrawables(null,null,drawable2,null);
            }
                tv3.setTextColor(Color.RED);
                break;
        }
        mTransaction.commit();

    }
    private void hide(FragmentTransaction ft) {
        if (fragement1 != null) {
            ft.hide(fragement1);
        }
        if (fragement2 != null) {
            ft.hide(fragement2);
        }
        if (fragement3 != null) {
            ft.hide(fragement3);
        }
        if (fragement4 != null) {
            ft.hide(fragement4);
        }
    }
}

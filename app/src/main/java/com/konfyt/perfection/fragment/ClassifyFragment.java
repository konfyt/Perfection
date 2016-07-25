package com.konfyt.perfection.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.konfyt.perfection.R;
import com.konfyt.perfection.activity.InClassify;
import com.konfyt.perfection.utils.UrlAddress;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

/**
 * A simple {@link Fragment} subclass.
 */
public class ClassifyFragment extends Fragment implements View.OnClickListener{



    public ClassifyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mView = inflater.inflate(R.layout.fragment_classify, container, false);
        initView(mView);
        return mView;
    }

    private void initView(View mView) {
        mView.findViewById(R.id.classify_ft_jiaju).setOnClickListener(this);
        mView.findViewById(R.id.classify_ft_shuma).setOnClickListener(this);
        mView.findViewById(R.id.classify_ft_chufang).setOnClickListener(this);
        mView.findViewById(R.id.classify_ft_zhuangshi).setOnClickListener(this);
        mView.findViewById(R.id.classify_ft_wanju).setOnClickListener(this);
        mView.findViewById(R.id.classify_ft_bangong).setOnClickListener(this);
        mView.findViewById(R.id.classify_ft_lvxing).setOnClickListener(this);
        mView.findViewById(R.id.classify_ft_huwai).setOnClickListener(this);
        mView.findViewById(R.id.classify_ft_zhinneg).setOnClickListener(this);
        mView.findViewById(R.id.classify_ft_weiyu).setOnClickListener(this);
        mView.findViewById(R.id.classify_ft_chaoliu).setOnClickListener(this);
        mView.findViewById(R.id.classify_ft_gehu).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent mIntent = new Intent(getActivity(), InClassify.class);
        mIntent.putExtra("path","http://qwapi.quwan.com/goods/goods_category/index");
        switch (view.getId()){
            case R.id.classify_ft_jiaju:
                mIntent.putExtra("cat_id","7701");
                mIntent.putExtra("title","家居日用");
                break;
            case R.id.classify_ft_shuma:
                mIntent.putExtra("cat_id","7709");
                mIntent.putExtra("title","数码3C");
                break;
            case R.id.classify_ft_chufang:
                mIntent.putExtra("cat_id","7703");
                mIntent.putExtra("title","厨房餐饮");
                break;
            case R.id.classify_ft_zhuangshi:
                mIntent.putExtra("cat_id","7702");
                mIntent.putExtra("title","装饰摆设");
                break;
            case R.id.classify_ft_wanju:
                mIntent.putExtra("cat_id","7705");
                mIntent.putExtra("title","玩具娱乐");
                break;
            case R.id.classify_ft_bangong:
                mIntent.putExtra("cat_id","7706");
                mIntent.putExtra("title","办公文具");
                break;
            case R.id.classify_ft_lvxing:
                mIntent.putExtra("cat_id","7707");
                mIntent.putExtra("title","旅行出游");
                break;
            case R.id.classify_ft_huwai:
                mIntent.putExtra("cat_id","7710");
                mIntent.putExtra("title","户外运动");
                break;
            case R.id.classify_ft_zhinneg:
                mIntent.putExtra("cat_id","7704");
                mIntent.putExtra("title","智能科技");
                break;
            case R.id.classify_ft_weiyu:
                mIntent.putExtra("cat_id","7711");
                mIntent.putExtra("title","卫浴清洁");
                break;
            case R.id.classify_ft_chaoliu:
                mIntent.putExtra("cat_id","7712");
                mIntent.putExtra("title","潮流装扮");
                break;
            case R.id.classify_ft_gehu:
                mIntent.putExtra("cat_id","7708");
                mIntent.putExtra("title","个护健康");
                break;
        }
        startActivity(mIntent);
    }



}

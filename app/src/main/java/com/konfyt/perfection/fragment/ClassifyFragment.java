package com.konfyt.perfection.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.konfyt.perfection.R;
import com.konfyt.perfection.utils.UrlAddress;

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
        switch (view.getId()){
            case R.id.classify_ft_jiaju:
                initData(UrlAddress.jiaJuNewPost);
                break;
            case R.id.classify_ft_shuma:
                break;
            case R.id.classify_ft_chufang:
                break;
            case R.id.classify_ft_zhuangshi:
                break;
            case R.id.classify_ft_wanju:
                break;
            case R.id.classify_ft_bangong:
                break;
            case R.id.classify_ft_lvxing:
                break;
            case R.id.classify_ft_huwai:
                break;
            case R.id.classify_ft_zhinneg:
                break;
            case R.id.classify_ft_weiyu:
                break;
            case R.id.classify_ft_chaoliu:
                break;
            case R.id.classify_ft_gehu:
                break;
        }
    }

    private void initData(String path) {

    }


}

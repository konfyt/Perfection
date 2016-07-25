package com.konfyt.perfection.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.konfyt.perfection.R;
import com.konfyt.perfection.adapter.ClassifyAdapter;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class InClassify extends AppCompatActivity {

    private GridView mGridView;
    private ClassifyAdapter mClassifyAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_in_classify);
        //查找控件
        mGridView = (GridView) findViewById(R.id.in_classify_gridview);
        mClassifyAdapter = new ClassifyAdapter();
        mGridView.setAdapter(mClassifyAdapter);
        //初始化数据
        initData();
    }

    private void initData() {
        OkHttpClient mClient = new OkHttpClient();
        Request mRequest = new Request.Builder()
                .url("")
                .build();
    }

    
}

package com.konfyt.perfection;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.google.gson.Gson;
import com.konfyt.perfection.adapter.Home_ftfour_four_adapter;
import com.konfyt.perfection.beans.Home;
import com.konfyt.perfection.beans.Home_four;
import okhttp3.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Home_ft_four_Activity extends AppCompatActivity {

    private ListView mListView;

    private String path="http://qwapi.quwan.com/zhuanti/zhuanti/zhuanti_list_v14";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_ft_four_);

        mListView = (ListView) findViewById(R.id.home_ft_four_item_lv);



        OkHttpClient okHttpClient = new OkHttpClient();

        Request mRequest = new Request.Builder()
                .url(path)
                .build();

        Call call = okHttpClient.newCall(mRequest);

        call.enqueue(new Callback() {


            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                if (response != null) {

                    String string = response.body().string();
                    Gson gson = new Gson();
                    Home_four home_four = gson.fromJson(string, Home_four.class);

                    //第一行数据
                    List<Home_four.DataBean.ZhuantiListBean> zhuanti_list = home_four.getData().getZhuanti_list();

                    if(zhuanti_list!=null){

                        Message obtain = Message.obtain();
                        obtain.obj=zhuanti_list;
                        mHandler.sendMessage(obtain);
                    }

                }
            }
        });






    }


    Handler mHandler=new Handler(){

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            List<Home_four.DataBean.ZhuantiListBean> zhuan = (List<Home_four.DataBean.ZhuantiListBean>) msg.obj;

            Home_ftfour_four_adapter mAdapter = new Home_ftfour_four_adapter(Home_ft_four_Activity.this);
            mListView.setAdapter(mAdapter);
            mAdapter.addData(zhuan);
        }
    };

    public void four(View view) {
        finish();
    }
}

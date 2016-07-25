package com.konfyt.perfection.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import com.google.gson.Gson;
import com.konfyt.perfection.R;
import com.konfyt.perfection.beans.Home;
import okhttp3.*;

import java.io.IOException;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment {

    //分类地址
    private String str="http://qwapi.quwan.com/home/home_v14/index";

    private ImageView mImageView;//放大镜

    public HomePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_homepage, container, false);

        mImageView = (ImageView) view.findViewById(R.id.home_ft_search);


        initUI();

        //放大镜,点击进行页面跳转
        mImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return view;
    }

    //网络请求数据
    private void initUI() {

        OkHttpClient okHttpClient = new OkHttpClient();

        Request mRequest=new Request.Builder()
                .url(str)
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
                    Home home = gson.fromJson(string, Home.class);

                    //第一行数据
                    List<Home.DataBean.BannerBean> banner = home.getData().getBanner();
                    //第二行数据
                    List<Home.DataBean.PlateBean> plate = home.getData().getPlate();
                    //第三行数据
                    List<Home.DataBean.ZhuantiListBean> zhuanti_list = home.getData().getZhuanti_list();
                    //第四行数据
                    List<Home.DataBean.WolegequBean> wolegequ = home.getData().getWolegequ();
                    //第五行数据
                    List<Home.DataBean.EverydaynewBean> everydaynew = home.getData().getEverydaynew();



                }
            }
        });


    }

}

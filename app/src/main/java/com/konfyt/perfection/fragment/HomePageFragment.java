package com.konfyt.perfection.fragment;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ScrollingView;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.*;
import com.google.gson.Gson;
import com.konfyt.perfection.Home_ft.Home_Ft_one;
import com.konfyt.perfection.Home_ft_four_Activity;
import com.konfyt.perfection.Home_two_Activity;
import com.konfyt.perfection.R;
import com.konfyt.perfection.activity.GoodInfo;
import com.konfyt.perfection.adapter.EveryPageAdapter;
import com.konfyt.perfection.adapter.Home_ft_five_adapter;
import com.konfyt.perfection.adapter.Home_ft_six_adapter;
import com.konfyt.perfection.adapter.Home_two_adapter;
import com.konfyt.perfection.beans.Home;
import com.konfyt.perfection.customview.AutoScrollViewPager;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import okhttp3.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomePageFragment extends Fragment {

    //分类地址
    private String str = "http://qwapi.quwan.com/home/home_v14/index";

    private ImageView mImageView;//放大镜
    private GridView mGridView;//第二行数据
    private AutoScrollViewPager mLayout;
    private List<Fragment> mFragments;//存放页面的集合
    //第三行的两张图片   两行文字  一个按钮
    private ImageView mImageView3;
    private ImageView mImageView4;
    private ImageView mImageView5;
    private TextView mTextView3;
    private TextView mTextView4;
    private TextView mTextView5;
    private RecyclerView mRecyclerView5;//第五行
    private LinearLayoutManager mLayoutManager;
    private ListView mListView6;
    private ScrollView mScrollView;

    private Home home;
    private List<Home.DataBean.ZhuantiListBean> zhuan;


    public HomePageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_homepage, container, false);

        mScrollView = (ScrollView) view.findViewById(R.id.home_ft_ScrollView);
        //   mScrollView.smoothScrollTo(0,0);


        //第一行控件
        mImageView = (ImageView) view.findViewById(R.id.home_ft_search);
        //第二行控件
        mGridView = (GridView) view.findViewById(R.id.home_ft_gridView);

        //第一行显示数据
        mLayout = (AutoScrollViewPager) view.findViewById(R.id.home_ft_ImageView1);

        //第三行控件
        mImageView3 = (ImageView) view.findViewById(R.id.home_ft_ImageView3);
        mImageView4 = (ImageView) view.findViewById(R.id.home_ft_ImageView4);
        mImageView5 = (ImageView) view.findViewById(R.id.home_ft_ImageView5);
        mTextView3 = (TextView) view.findViewById(R.id.home_ft_TextView22);
        mTextView4 = (TextView) view.findViewById(R.id.home_ft_TextView33);
        mTextView5 = (TextView) view.findViewById(R.id.home_ft_TextView44);

        //第五行控件
        mRecyclerView5 = (RecyclerView) view.findViewById(R.id.home_ft_RecyclerView5);

        //第六行控件
        mListView6 = (ListView) view.findViewById(R.id.home_ft_ListView6);


        //创建线性布局
        mLayoutManager = new LinearLayoutManager(getActivity());
        //垂直方向
        mLayoutManager.setOrientation(OrientationHelper.HORIZONTAL);
        mRecyclerView5.setLayoutManager(mLayoutManager);


//        //默认显示一行   这样显示四行
//        GridLayoutManager manager=new GridLayoutManager(getActivity(),4);
//        mRecyclerView5.setLayoutManager(manager);

        //第一行页面集合
        mFragments = new ArrayList<>();

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

        Request mRequest = new Request.Builder()
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
                    home = gson.fromJson(string, Home.class);

                    //第一行数据
                   List<Home.DataBean.BannerBean> banner = home.getData().getBanner();
                    //第二行数据
                    List<Home.DataBean.PlateBean> plate = home.getData().getPlate();
                    //第三行数据
                    List<Home.DataBean.ZhuantiListBean> zhuanti_list = home.getData().getZhuanti_list();
                    //第五行数据
                    List<Home.DataBean.WolegequBean> wolegequ = home.getData().getWolegequ();
                    //第六行数据
                    List<Home.DataBean.EverydaynewBean> everydaynew = home.getData().getEverydaynew();


                    if (banner != null) {
                        Message obtain = Message.obtain();
                        obtain.obj = banner;
                        obtain.what = 1;
                        mHandler.sendMessage(obtain);
                    }
                    if (plate != null) {
                        Message obtain = Message.obtain();
                        obtain.obj = plate;
                        obtain.what = 2;
                        mHandler.sendMessage(obtain);
                    }

                    if (zhuanti_list != null) {
                        Message obtain = Message.obtain();
                        obtain.obj = zhuanti_list;
                        obtain.what = 3;
                        mHandler.sendMessage(obtain);
                    }

                    if (wolegequ != null) {
                        Message obtain = Message.obtain();
                        obtain.obj = wolegequ;
                        obtain.what = 5;
                        mHandler.sendMessage(obtain);
                    }

                    if (everydaynew != null) {
                        Message obtain = Message.obtain();
                        obtain.obj = everydaynew;
                        obtain.what = 6;
                        mHandler.sendMessage(obtain);
                    }

                }
            }
        });


    }

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            switch (msg.what) {

                case 1:
                    final List<Home.DataBean.BannerBean> banner = (List<Home.DataBean.BannerBean>) msg.obj;

                    for (int i = 0; i < banner.size(); i++) {
                        Home.DataBean.BannerBean bannerBean1 = banner.get(i);
                        mFragments.add(Home_Ft_one.newInstance(bannerBean1));
                    }

                    if (mFragments != null) {
                        mLayout.setAdapter(new EveryPageAdapter(mFragments, getFragmentManager()));
                        mLayout.startAutoScroll();
                    }


                    break;

                case 2:
                    List<Home.DataBean.PlateBean> plate = (List<Home.DataBean.PlateBean>) msg.obj;

                    Home_two_adapter mAdapter2 = new Home_two_adapter(getActivity());
                    mGridView.setAdapter(mAdapter2);
                    mAdapter2.addData(plate);

                    mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                            Intent intent2 = new Intent(getActivity(), Home_two_Activity.class);

                            startActivity(intent2);
                        }
                    });

                    break;

                case 3:
                    zhuan = (List<Home.DataBean.ZhuantiListBean>) msg.obj;

                    mTextView3.setText(zhuan.get(0).getConfig_specname());
                    mTextView4.setText(zhuan.get(1).getConfig_specname());

                    DisplayImageOptions options = new DisplayImageOptions.Builder()
                            .cacheInMemory(true)//具有内存缓存
                            .cacheOnDisk(true)//具有磁盘缓存
                            .bitmapConfig(Bitmap.Config.RGB_565)//图片的解码方式
                            .build();
                    ImageLoader.getInstance().displayImage(zhuan.get(0).getPicture_url(), mImageView3, options);
                    ImageLoader.getInstance().displayImage(zhuan.get(1).getPicture_url(), mImageView4, options);

                    mImageView3.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            five();
                        }
                    });
                    mImageView4.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            five();
                        }
                    });
                    mImageView5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            five();
                        }
                    });
                    mTextView5.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            five();
                        }
                    });


                    break;

                case 5:
                    List<Home.DataBean.WolegequBean> woleg = (List<Home.DataBean.WolegequBean>) msg.obj;


                    Home_ft_five_adapter mAdapter5 = new Home_ft_five_adapter(getActivity());
                    mRecyclerView5.setAdapter(mAdapter5);
                    mAdapter5.addData(woleg);


                    break;
                case 6:

                    List<Home.DataBean.EverydaynewBean> every = (List<Home.DataBean.EverydaynewBean>) msg.obj;

                    Home_ft_six_adapter mAdapter6 = new Home_ft_six_adapter(getContext());
                    mListView6.setAdapter(mAdapter6);
                    mAdapter6.addData(every);


                    break;
            }

        }
    };

    private void five() {
        Intent intent = new Intent(getActivity(), Home_ft_four_Activity.class);


        startActivity(intent);
    }
}

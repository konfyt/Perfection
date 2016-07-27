package com.konfyt.perfection.activity;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.konfyt.perfection.R;
import com.konfyt.perfection.adapter.GoodsAdapter;
import com.konfyt.perfection.beans.ClassifySale;
import com.konfyt.perfection.beans.Goods;
import com.konfyt.perfection.customview.NoScrollGirdView;
import com.konfyt.perfection.customview.NoScrollViewPager;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class GoodInfo extends AppCompatActivity {
    private ViewPager mViewPager;
    private WebView mWebView;
    private List<ImageView> imgs;
    private MyAdapter mMyAdapter;
    private DisplayImageOptions options;
    private NoScrollGirdView mGridView;
    private GoodsAdapter adapter;
    private Goods mGoods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_info);
        initView();
        initData(getIntent().getStringExtra("idid"));
    }

    private void initView() {
        mViewPager = (ViewPager) findViewById(R.id.goods_info_viewpager);
        mWebView = (WebView) findViewById(R.id.goods_info_webview);
        imgs = new ArrayList<>();
        mMyAdapter = new MyAdapter();
        adapter = new GoodsAdapter(this);
        mViewPager.setAdapter(mMyAdapter);
        mWebView.getSettings().setLoadWithOverviewMode(true);
        mGridView = (NoScrollGirdView) findViewById(R.id.goods_info_shop_view);
        options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//具有内存缓存
                .cacheOnDisk(true)//具有磁盘缓存
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        mGridView.setAdapter(adapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               // imgs.clear();
                List<String> mPic_arr = mGoods.getData().getGoods().get(i).getPic_arr();
                getImg(mPic_arr);
            }
        });
    }

    private void initData(String id) {
        String path =
                "http://qwapi.quwan.com/goods/goods_info";
        String a = "goods_id";
        OkHttpClient mClient = new OkHttpClient();
        RequestBody mBody = new FormBody.Builder()
                .add(a,id)
                .build();

        Request mRequest = new Request.Builder()
                .url(path)
                .post(mBody)
                .build();
        Call mCall = mClient.newCall(mRequest);
        mCall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String mString = response.body().string();
                Gson mGson = new Gson();
                mGoods = mGson.fromJson(mString, Goods.class);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        TextView name = (TextView) findViewById(R.id.goods_info_name);
                        name.setText(mGoods.getData().getGoods().get(0).getGoods_name());
                        ((TextView) findViewById(R.id.goods_info_goods_brand)).setText(mGoods.getData().getGoods().get(0).getGoods_brand());
                        ((TextView) findViewById(R.id.goods_info_shop_price)).setText("￥"+mGoods.getData().getGoods().get(0).getShop_price());
                        mWebView.loadDataWithBaseURL(null, mGoods.getData().getGoods_detail(), "text/html", "utf-8", null);
                        List<String> mPic_arr = mGoods.getData().getGoods().get(0).getPic_arr();
                        getImg(mPic_arr);
                        List<Goods.DataBean.GoodsBean> mGoods1 = mGoods.getData().getGoods();
                        adapter.addData(mGoods1);
                    }
                });
            }


        });
    }

    private void getImg(List<String> mPic_arr) {

        imgs.clear();
        for (int i = 0; i < mPic_arr.size(); i++) {
            ImageView mImageView = new ImageView(GoodInfo.this);
            ImageLoader.getInstance().displayImage(mPic_arr.get(i),mImageView,options);
            mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imgs.add(mImageView);
        }
        mMyAdapter.setList(imgs);
        mMyAdapter.notifyDataSetChanged();

    }

    Handler mHandler = new Handler();

    class MyAdapter extends PagerAdapter{

        private List<ImageView> myList = new ArrayList<>();

        public void setList(List<ImageView> list){
            myList.clear();
            myList.addAll(list);
        }

        @Override
        public int getCount() {
            return myList==null?0:myList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
//            if(myList.size()<= position-1){
//            Log.e("AAA","==>"+position);
//               // container.removeView(myList.get(position));
//            }

        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
             container.addView(imgs.get(position));
            return myList.get(position);
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }
    }


}

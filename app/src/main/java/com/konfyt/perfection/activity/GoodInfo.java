package com.konfyt.perfection.activity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.gson.Gson;
import com.konfyt.perfection.DBHelper;
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
    private Button canshuBtn;
    private Button addGoods;
    private int position=0;
    private SQLiteDatabase db;
    private DBHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_good_info);
        mHelper = new DBHelper(this);
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
                position=i;
               // imgs.clear();
                List<String> mPic_arr = mGoods.getData().getGoods().get(i).getPic_arr();
                getImg(mPic_arr);
            }
        });
        canshuBtn = (Button) findViewById(R.id.goods_info_canshu);
        canshuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopwindow();
            }
        });
        findViewById(R.id.info_fanhui).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        addGoods = (Button) findViewById(R.id.addfoods);
        addGoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Goods.DataBean.GoodsBean mGoodsBean = mGoods.getData().getGoods().get(position);
                String mPic = mGoodsBean.getSmall_pic();
                String mId = mGoods.getData().getGoods().get(0).getGoods_id();
                String nowId = mGoods.getData().getGoods().get(position).getGoods_id();
                String mName = mGoodsBean.getGoods_name();
                String mPrice = mGoodsBean.getShop_price();
                db = mHelper.getWritableDatabase();
                Cursor mGoods = db.query("goods", new String[]{"_id", "goodid","num"}, "goodid=?", new String[]{nowId+""}, null, null, null);
                if (mGoods.getCount()>0) {
                    if (mGoods.moveToNext()){
                        int mNum = mGoods.getInt(mGoods.getColumnIndex("num"));
                        int id = mGoods.getInt(mGoods.getColumnIndex("_id"));
                        ContentValues mContentValues = new ContentValues();
                        mContentValues.put("num",mNum+1);
                        db.update("goods",mContentValues,"_id=?",new String[]{id+""});
                    }
                }else {
                    ContentValues mValues = new ContentValues();
                    mValues.put("pic",mPic);
                    mValues.put("name",mName);
                    mValues.put("price",mPrice);
                    mValues.put("num",1);
                    mValues.put("goodid",nowId);
                    mValues.put("tiaozhuanid",mId);
                    db.insert("goods",null,mValues);
                }
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

    public void back(View view) {
        finish();
    }

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


    private void showPopwindow() {
        // 利用layoutInflater获得View
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.canshu_popwindow, null);
        ListView mListView = (ListView) view.findViewById(R.id.pop_lv);
        List<Goods.DataBean.GoodsBean.GoodsAttrBean> mPic_arr = mGoods.getData().getGoods().get(0).getGoods_attr();
        List<String> mList = new ArrayList<>();
        for (int i = 0; i < mPic_arr.size(); i++) {
            Goods.DataBean.GoodsBean.GoodsAttrBean mGoodsAttrBean = mPic_arr.get(i);
            mList.add(mGoodsAttrBean.getK()+"  "+mGoodsAttrBean.getV());
        }
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,mList);
        mListView.setAdapter(mAdapter);
        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()

        final PopupWindow window = new PopupWindow(view,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);



        // 设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.mypopwindow_anim_style);
        // 在底部显示
        window.showAtLocation(findViewById(R.id.pop_relative),
                Gravity.BOTTOM, 0, 0);


        ImageView img = (ImageView) view.findViewById(R.id.pop_guanbi);
        img.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                window.dismiss();
            }
        });


    }
    private void showPopwindowBuy() {
        // 利用layoutInflater获得View
        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.gouwu_popwindow, null);
        ListView mListView = (ListView) view.findViewById(R.id.pop_lv);

        // 下面是两种方法得到宽度和高度 getWindow().getDecorView().getWidth()

        final PopupWindow window = new PopupWindow(view,
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT);

        // 设置popWindow弹出窗体可点击，这句话必须添加，并且是true
        window.setFocusable(true);



        // 设置popWindow的显示和消失动画
        window.setAnimationStyle(R.style.mypopwindow_anim_style);
        // 在底部显示
        window.showAtLocation(findViewById(R.id.pop_relative),
                Gravity.BOTTOM, 0, 0);


        ImageView img = (ImageView) view.findViewById(R.id.pop_guanbi);
        img.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                window.dismiss();
            }
        });


    }
}

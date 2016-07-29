package com.konfyt.perfection.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.konfyt.perfection.Home_two_Activity;
import com.konfyt.perfection.R;
import com.konfyt.perfection.activity.GoodInfo;
import com.konfyt.perfection.beans.Home;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by XCQ on 16/7/26.
 */
public class Home_ft_six_adapter extends BaseAdapter {

    private Context mContext;
    private List<Home.DataBean.EverydaynewBean> every;
    private LayoutInflater mInflater;

    private String goods_id;

    public Home_ft_six_adapter(Context mContext) {
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
        every = new ArrayList<>();
    }

    public void addData(List<Home.DataBean.EverydaynewBean> data) {
        every.addAll(data);
        notifyDataSetChanged();
    }

    public void clearData() {
        every.clear();
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return every.size();
    }

    @Override
    public Object getItem(int i) {
        return every.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        ViewHolder mHolder = null;
        if (view == null) {
            view = mInflater.inflate(R.layout.home_ft_six_item, viewGroup, false);
            mHolder = new ViewHolder();
            mHolder.im1 = (ImageView) view.findViewById(R.id.home_ft_six_im);
            mHolder.tv1 = (TextView) view.findViewById(R.id.home_ft_six_tv1);
            mHolder.tv2 = (TextView) view.findViewById(R.id.home_ft_six_tv2);
            mHolder.tv3 = (TextView) view.findViewById(R.id.home_ft_six_tv3);
            mHolder.bt1 = (Button) view.findViewById(R.id.six_button1);
            mHolder.bt2 = (Button) view.findViewById(R.id.six_button2);
            mHolder.bt3 = (Button) view.findViewById(R.id.six_button3);
            view.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) view.getTag();
        }

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//具有内存缓存
                .cacheOnDisk(true)//具有磁盘缓存
                .bitmapConfig(Bitmap.Config.RGB_565)//图片的解码方式
                .build();
        ImageLoader.getInstance().displayImage(every.get(i).getOriginal_img(), mHolder.im1, options);

        mHolder.tv1.setText(every.get(i).getGoods_name());
        mHolder.tv2.setText(every.get(i).getPromote_price());
        mHolder.tv3.setText(every.get(i).getWenan());

         goods_id = every.get(i).getGoods_id();
        //图片的点击事件
        mHolder.im1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                showInfo(goods_id);

            }

        });

        //喜欢的点击事件
        mHolder.bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfo2();
            }
        });
        //分享的点击事件
        mHolder.bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfo2();
            }
        });
        //查看详情的点击事件
        mHolder.bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showInfo(goods_id);
            }
        });

        return view;
    }

    static class ViewHolder {

        TextView tv1, tv2, tv3;
        ImageView im1;
        Button bt1, bt2, bt3;
    }

    // 图片的点击事件  处理
    private void showInfo(String goods_id) {
        Intent intent = new Intent(mContext, GoodInfo.class);

        intent.putExtra("idid", goods_id);

        mContext.startActivity(intent);

    }

    // 图片的点击事件  处理
    private void showInfo2() {
        Intent intent = new Intent(mContext, Home_two_Activity.class);


        mContext.startActivity(intent);

    }
}

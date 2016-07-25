package com.konfyt.perfection.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.konfyt.perfection.R;
import com.konfyt.perfection.beans.ClassifySale;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konfyt on 2016/7/24.
 */
public class ClassifyAdapter extends BaseAdapter {


    private LayoutInflater mInflater;
    private List<ClassifySale.DataBean.CatGoodsBean> mList;

    public ClassifyAdapter(Context context) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mList==null?0:mList.size();
    }

    @Override
    public Object getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View converView, ViewGroup viewGroup) {
        ViewHoder mHoder = null;
        if (mHoder == null) {
            converView = mInflater.inflate(R.layout.classify_item,null);
            mHoder = new ViewHoder();
            mHoder.mImageView = (ImageView) converView.findViewById(R.id.classify_item_img);
            mHoder.name = (TextView) converView.findViewById(R.id.classify_item_name);
            mHoder.price = (TextView) converView.findViewById(R.id.classify_item_price);
            converView.setTag(mHoder);
        }else {
            mHoder = (ViewHoder) converView.getTag();
        }
        mHoder.name.setText(mList.get(i).getGoods_name());
        mHoder.price.setText("￥"+mList.get(i).getShop_price());
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//具有内存缓存
                .cacheOnDisk(true)//具有磁盘缓存
                .bitmapConfig(Bitmap.Config.RGB_565)//图片的解码方式
                .build();
        ImageLoader.getInstance().displayImage(mList.get(i).getOriginal_img(),mHoder.mImageView,options);
        return converView;
    }

    public void addData(List<ClassifySale.DataBean.CatGoodsBean> data){
        mList.addAll(data);
        notifyDataSetChanged();
    }
    class ViewHoder {

        ImageView mImageView;
        TextView name;
        TextView price;
    }
}
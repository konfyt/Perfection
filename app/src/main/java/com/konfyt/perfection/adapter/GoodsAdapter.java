package com.konfyt.perfection.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.konfyt.perfection.R;
import com.konfyt.perfection.beans.ClassifySale;
import com.konfyt.perfection.beans.Goods;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Konfyt on 2016/7/26.
 */
public class GoodsAdapter extends BaseAdapter{
    private LayoutInflater mInflater;
    private List<Goods.DataBean.GoodsBean> mList;

    public GoodsAdapter(Context context) {
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
            converView = mInflater.inflate(R.layout.goodsitem,null);
            mHoder = new ViewHoder();
            mHoder.mImageView = (ImageView) converView.findViewById(R.id.goods_small_img);
            converView.setTag(mHoder);
        }else {
            mHoder = (ViewHoder) converView.getTag();
        }
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//具有内存缓存
                .cacheOnDisk(true)//具有磁盘缓存
                .bitmapConfig(Bitmap.Config.RGB_565)//图片的解码方式
                .build();
        ImageLoader.getInstance().displayImage(mList.get(i).getSmall_pic(),mHoder.mImageView,options);
        return converView;
    }

    public void addData(List<Goods.DataBean.GoodsBean> data){
        mList.addAll(data);
        notifyDataSetChanged();
    }



    class ViewHoder {
        ImageView mImageView;
    }
}

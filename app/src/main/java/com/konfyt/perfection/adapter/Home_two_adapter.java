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
import com.konfyt.perfection.beans.Home;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XCQ on 16/7/25.
 */
public class Home_two_adapter extends BaseAdapter {

    private Context mContext;
    private List<Home.DataBean.PlateBean> plate;


    public Home_two_adapter(Context mContext) {
        this.mContext = mContext;
        plate = new ArrayList<>();

    }

    public void addData(List<Home.DataBean.PlateBean> data) {
        plate.addAll(data);
        notifyDataSetChanged();
    }

    public void clearData() {
        plate.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return plate == null ? 0 : plate.size();
    }

    @Override
    public Object getItem(int i) {
        return plate.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder mHolder = null;

        if (view == null) {
            view = ((LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                    .inflate(R.layout.home_ft_two_item, null);


            mHolder = new ViewHolder();
            mHolder.im = (ImageView) view.findViewById(R.id.home_two_item_im);
            mHolder.tv = (TextView) view.findViewById(R.id.home_two_item_tv);
            view.setTag(mHolder);

        } else {
            mHolder = (ViewHolder) view.getTag();
        }


        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//具有内存缓存
                .cacheOnDisk(true)//具有磁盘缓存
                .bitmapConfig(Bitmap.Config.RGB_565)//图片的解码方式
                .build();
        if (plate != null) {
            ImageLoader.getInstance().displayImage(plate.get(i).getPicture_url(), mHolder.im, options);

            mHolder.tv.setText(plate.get(i).getName());
        }
        return view;
    }


    class ViewHolder {
        ImageView im;
        TextView tv;
    }
}

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
import com.konfyt.perfection.beans.Home;
import com.konfyt.perfection.beans.Home_four;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import static com.konfyt.perfection.R.layout.home_ft_four_item;

/**
 * Created by XCQ on 16/7/27.
 */
public class Home_ftfour_four_adapter extends BaseAdapter {


    private Context mContext;
    private List<Home_four.DataBean.ZhuantiListBean> zhuan;
    private LayoutInflater mInflater;

    public Home_ftfour_four_adapter(Context mContext) {
        mInflater = LayoutInflater.from(mContext);
        zhuan = new ArrayList<>();
    }

    public void addData(List<Home_four.DataBean.ZhuantiListBean> data) {
        zhuan.addAll(data);
        notifyDataSetChanged();
    }

    public void clearData() {
        zhuan.clear();
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return zhuan.size();
    }

    @Override
    public Object getItem(int i) {
        return zhuan.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViweHolder mHolder = null;
        if (view == null) {

            view = mInflater.inflate(R.layout.home_ft_four_item, viewGroup, false);
            mHolder = new ViweHolder();
            mHolder.im = (ImageView) view.findViewById(R.id.home_four_item_ImageView1);
            mHolder.tv = (TextView) view.findViewById(R.id.home_four_item_TextView1);
            view.setTag(mHolder);
        } else {
            mHolder = (ViweHolder) view.getTag();
        }
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//具有内存缓存
                .cacheOnDisk(true)//具有磁盘缓存
                .bitmapConfig(Bitmap.Config.RGB_565)//图片的解码方式
                .build();
        ImageLoader.getInstance().displayImage(zhuan.get(i).getPicture_url(), mHolder.im, options);

        mHolder.tv.setText(zhuan.get(i).getConfig_specname());

        return view;
    }


    static class ViweHolder {
        TextView tv;
        ImageView im;

    }
}

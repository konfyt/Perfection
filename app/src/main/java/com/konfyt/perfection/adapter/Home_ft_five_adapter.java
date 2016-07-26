package com.konfyt.perfection.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.konfyt.perfection.R;
import com.konfyt.perfection.beans.Home;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by XCQ on 16/7/26.
 */
public class Home_ft_five_adapter extends RecyclerView.Adapter<Home_ft_five_adapter.ViewHolder> {

    private Context mContext;
    private List<Home.DataBean.WolegequBean> woleg;
    private LayoutInflater mInflater;

    public Home_ft_five_adapter(Context mContext) {
        mInflater = LayoutInflater.from(mContext);
        woleg = new ArrayList<>();
    }

    public void addData(List<Home.DataBean.WolegequBean> data) {
        woleg.addAll(data);
        notifyDataSetChanged();
    }

    public void clearData() {
        woleg.clear();
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mInflater.inflate(R.layout.home_ft_five_item, parent, false);

        ViewHolder mHolder=new ViewHolder(view);

        return mHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//具有内存缓存
                .cacheOnDisk(true)//具有磁盘缓存
                .bitmapConfig(Bitmap.Config.RGB_565)//图片的解码方式
                .build();
        ImageLoader.getInstance().displayImage(woleg.get(position).getOriginal_img(),holder.im,options);


        holder.tv.setText(woleg.get(position).getGoods_name());

    }

    @Override
    public int getItemCount() {
        return woleg.size();
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView tv;
        ImageView im;

        public ViewHolder(View itemView) {
            super(itemView);

            tv = (TextView) itemView.findViewById(R.id.home_ft_five_TextView);
            im = (ImageView) itemView.findViewById(R.id.home_ft_five_item);
        }
    }
}

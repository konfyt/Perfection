package com.konfyt.perfection.Home_ft;


import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import com.konfyt.perfection.R;
import com.konfyt.perfection.activity.GoodInfo;
import com.konfyt.perfection.beans.Home;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home_Ft_one extends Fragment {



    private  Home.DataBean.BannerBean aa;
    private ImageView imageView;
    public Home_Ft_one() {
        // Required empty public constructor
    }


    public static Home_Ft_one newInstance(Home.DataBean.BannerBean bannerBean) {

        Bundle args = new Bundle();
        args.putSerializable("aa",bannerBean);
        Home_Ft_one fragment = new Home_Ft_one();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_home__ft_ont, container, false);

         imageView = (ImageView) view.findViewById(R.id.home_ft_one_ft_im);

        Bundle bundle = getArguments();

        aa = (Home.DataBean.BannerBean) bundle.getSerializable("aa");




        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .cacheInMemory(true)//具有内存缓存
                .cacheOnDisk(true)//具有磁盘缓存
                .bitmapConfig(Bitmap.Config.RGB_565)//图片的解码方式
                .build();
        ImageLoader.getInstance().displayImage(aa.getPicture_url(),imageView,options);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getActivity(), GoodInfo.class);

                String id = aa.getGoodsinfo().getGoods_id();
                intent1.putExtra("idid", id);

                startActivity(intent1);
            }
        });


        return view;

    }

}

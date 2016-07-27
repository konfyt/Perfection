package com.konfyt.perfection.customview;


import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.SyncStateContract;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import java.io.File;

/**
 * Created by Konfyt on 2016/7/24.
 */
public class A extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        initUIL();
    }

    //初始化 UIL
    private void initUIL() {
        //方式一  初始化 UIL

//        //1,声明配置信息
//        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
//        //2,进行初始化配置
//        ImageLoader.getInstance().init(configuration);

        //方式二  自定义配置

        File file = new File(Environment.getExternalStorageDirectory(),"imgcache");
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .threadPoolSize(3)//线程池大小  1-5
                .memoryCacheSize(10*1024*1024) //配置内存大小
                .diskCacheSize(100*1024*1024) //配置磁盘大小
                .diskCacheFileCount(100)  //配置磁盘缓存文件的数量
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())//磁盘缓存文件的命名器
                .diskCache(new UnlimitedDiskCache(file))//定义磁盘缓存文件
                .build();

        //进行全局初始化
        ImageLoader.getInstance().init(configuration);

    }
}

package com.konfyt.perfection.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Konfyt on 2016/7/24.
 */
public class ClassifyAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<ClassifyAdapter> mList;

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }


    class ViewHoder {


        ImageView mImageView;
        TextView name;
        TextView price;

    }
}
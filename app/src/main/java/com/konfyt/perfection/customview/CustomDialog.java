package com.konfyt.perfection.customview;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.konfyt.perfection.R;

/**
 * Created by Konfyt on 2016/7/23.
 */
public class CustomDialog {


    private AlertDialog dialog;
    private ImageView img;
    private Context context;
    public CustomDialog(Context context) {
        this.context = context;
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = mInflater.inflate(R.layout.customdialog, null);
        img = (ImageView) view.findViewById(R.id.dialog_img);
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(context);
        this.dialog = mBuilder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setView(view,0,0,0,0);
    }

    public void show(){
        dialog.show();
        AnimationDrawable mDrawable = (AnimationDrawable) img.getBackground();
        mDrawable.start();
        dialog.getWindow().setLayout(dip2px(context,120.0f),dip2px(context,120.0f));
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_bg);
    }


    public void dismiss(){
        dialog.dismiss();
    }

    private  int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
    private static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}

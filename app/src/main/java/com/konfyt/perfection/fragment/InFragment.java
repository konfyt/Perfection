package com.konfyt.perfection.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.google.gson.Gson;
import com.konfyt.perfection.R;
import com.konfyt.perfection.adapter.ClassifyAdapter;
import com.konfyt.perfection.beans.ClassifySale;
import com.konfyt.perfection.customview.CustomDialog;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class InFragment extends Fragment {
    private int currentPage = 0;
    private int count = 1;
    private CustomDialog mDialog ;
    private GridView mGridView;
    private ClassifyAdapter mAdapter;

    public static InFragment newInstance(String path,String id,String sort1,String sort2) {

        Bundle args = new Bundle();
        args.putString("PATH",path);
        args.putString("ID",id);
        args.putString("sort1",sort1);
        args.putString("sort2",sort2);

        InFragment fragment = new InFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        mDialog= new CustomDialog(getActivity());
        View mView = inflater.inflate(R.layout.fragment_in, container, false);
        Bundle mBundle = getArguments();
        initData(mBundle.getString("PATH"),mBundle.getString("sort1"),mBundle.getString("ID"));
        mDialog.show();
        mGridView = (GridView) mView.findViewById(R.id.fragment_in_gridview);
        mAdapter = new ClassifyAdapter(getActivity());
        mGridView.setAdapter(mAdapter);

        return mView;
    }


        //初始化数据
        private void initData(String path,String sort,String cat_id) {
        OkHttpClient mClient = new OkHttpClient();
        RequestBody mBody = new FormBody.Builder()
                .add("sort",sort)
                .add("cat_id",cat_id)
                .add("page",currentPage+"")
                .add("pagesize","10")
                .build();

        Request mRequest = new Request.Builder()
                .url(path)
                // post(okhttp3.RequestBody body)
                .post(mBody)
                .build();
            Call mCall = mClient.newCall(mRequest);
            mCall.enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String mString = response.body().string();
                    if (count==1) {
                        mDialog.dismiss();
                        count=2;
                    }
                    Gson mGson = new Gson();
                    ClassifySale mClassifySale = mGson.fromJson(mString, ClassifySale.class);
                    final List<ClassifySale.DataBean.CatGoodsBean> mCat_goods = mClassifySale.getData().getCat_goods();
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mAdapter.addData(mCat_goods);
                        }
                    });
                }
            });
      }

    Handler mHandler = new Handler();

}

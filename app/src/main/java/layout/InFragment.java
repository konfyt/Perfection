package layout;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.konfyt.perfection.R;
import com.konfyt.perfection.customview.CustomDialog;

import java.io.IOException;

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
    private CustomDialog mDialog = new CustomDialog(getActivity());

    public static InFragment newInstance(String path,String id) {

        Bundle args = new Bundle();
        args.putString("PATH",path);
        args.putString("ID",id);

        InFragment fragment = new InFragment();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View mView = inflater.inflate(R.layout.fragment_in, container, false);
        Bundle mBundle = getArguments();
        initData(mBundle.getString("PATH"),"1",mBundle.getString("ID"));
        mDialog.show();
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

                }
            });
      }

}

package com.konfyt.perfection.fragment;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.konfyt.perfection.DBHelper;
import com.konfyt.perfection.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShoppingCartFragment extends Fragment {
    private MyCursorAdapter mAdapter;
    private SQLiteDatabase db;
    private ListView mListView;

    public ShoppingCartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mInflate = inflater.inflate(R.layout.fragment_shoppingcart, container, false);
        DBHelper mHelper = new DBHelper(getActivity());
        db = mHelper.getWritableDatabase();
        Cursor mGoods = db.query("goods", new String[]{"_id", "pic", "name", "price", "goodid", "tiaozhuanid"}, null, null,null,null, null);

        mAdapter = new MyCursorAdapter(getActivity(),R.layout.cat_item,mGoods,
                new String[]{"pic", "name", "price"},
        new int[]{R.id.cat_item_img,R.id.cat_item_name,R.id.classify_item_price});
        mListView = (ListView) mInflate.findViewById(R.id.cat_lv);
        mListView.setAdapter(mAdapter);
        return mInflate;
    }



    class MyCursorAdapter extends SimpleCursorAdapter{

        public MyCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to) {
            super(context, layout, c, from, to);
        }
    }

}

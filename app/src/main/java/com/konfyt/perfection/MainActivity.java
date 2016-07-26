package com.konfyt.perfection;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.konfyt.perfection.fragment.ClassifyFragment;
import com.konfyt.perfection.fragment.HomePageFragment;
import com.konfyt.perfection.fragment.MeFragment;
import com.konfyt.perfection.fragment.ShoppingCartFragment;

public class MainActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private FragmentManager fm;
    private HomePageFragment mHomePageFragment;
    private ClassifyFragment mClassifyFragment;
    private MeFragment mMeFragment;
    private ShoppingCartFragment mShoppingCartFragment;
    private ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //查找RadioGroup
        radioGroup = (RadioGroup) findViewById(R.id.activity_main_radioGroup);
        //获取碎片管理器
        fm = getSupportFragmentManager();
        //默认加载第一页
        if (mHomePageFragment == null) {
            mHomePageFragment = new HomePageFragment();
        }
        fm.beginTransaction().add(R.id.activity_main_container,mHomePageFragment).commit();
        //给RadioGroup设置监听事件
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                //开启事物
                FragmentTransaction ft = fm.beginTransaction();
                //一开始全部隐藏掉,自定义hide方法
                hide(ft);
                //选中事件,hide,show,add
                switch (checkedId) {
                    case R.id.activity_main_radioButton1:
                        //如果添加过就直接显示
                        if (mHomePageFragment!=null&&mHomePageFragment.isAdded()) {
                            ft.show(mHomePageFragment);
                        }else {
                            //第一次创建fragment对象并添加到事务处理处理当中
                            mHomePageFragment = new HomePageFragment();
                            ft.add(R.id.activity_main_container,mHomePageFragment);
                        }
                        break;
                    case R.id.activity_main_radioButton2:
                        if (mClassifyFragment!=null&&mClassifyFragment.isAdded()) {
                            ft.show(mClassifyFragment);
                        }else {
                            mClassifyFragment = new ClassifyFragment();
                            ft.add(R.id.activity_main_container,mClassifyFragment);
                        }
                        break;
                    case R.id.activity_main_radioButton3:
                        if (mShoppingCartFragment!=null&&mShoppingCartFragment.isAdded()) {
                            ft.show(mShoppingCartFragment);
                        }else {
                            mShoppingCartFragment = new ShoppingCartFragment();
                            ft.add(R.id.activity_main_container,mShoppingCartFragment);
                        }
                        break;
                    case R.id.activity_main_radioButton4:
                        if (mMeFragment!=null&&mMeFragment.isAdded()) {
                            ft.show(mMeFragment);
                        }else {
                            mMeFragment = new MeFragment();
                            ft.add(R.id.activity_main_container,mMeFragment);
                        }
                        break;
                }
                //提交事物
                ft.commit();
            }

            private void hide(FragmentTransaction ft) {
                if (mHomePageFragment != null) {
                    ft.hide(mHomePageFragment);
                }
                if (mClassifyFragment != null) {
                    ft.hide(mClassifyFragment);
                }
                if (mShoppingCartFragment != null) {
                    ft.hide(mShoppingCartFragment);
                }
                if (mMeFragment != null) {
                    ft.hide(mMeFragment);
                }
            }
        });
    }
}

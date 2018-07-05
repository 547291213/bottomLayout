package com.example.xkfeng.bottomlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.xkfeng.bottomlayout.Fragment.FourFragment;
import com.example.xkfeng.bottomlayout.Fragment.OneFragment;
import com.example.xkfeng.bottomlayout.Fragment.ThreeFragment;
import com.example.xkfeng.bottomlayout.Fragment.TwoFragment;

/**
 * Created by initializing on 2018/7/4.
 */

public class ButtonNavicationBarActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    private BottomNavigationBar bar ;
    private OneFragment oneFragment ;
    private TwoFragment twoFragment ;
    private ThreeFragment threeFragment ;
    private FourFragment fourFragment ;
    private FragmentTransaction transaction ;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buttomnavicationbar);

        bar = (BottomNavigationBar)findViewById(R.id.bnb_navigationBar) ;
        /*
                 setMode 的样式选择
                         *  BACKGROUND_STYLE_DEFAULT: 默认样式 如果设置的Mode为MODE_FIXED，将使用BACKGROUND_STYLE_STATIC
                 *                                    如果Mode为MODE_SHIFTING将使用BACKGROUND_STYLE_RIPPLE。
                 *  BACKGROUND_STYLE_STATIC: 静态样式 点击无波纹效果
                 *  BACKGROUND_STYLE_RIPPLE: 波纹样式 点击有波纹效果
         */
        bar
        .setMode(BottomNavigationBar.MODE_FIXED)
        .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
        .setActiveColor("#7CFC00")
        .setInActiveColor("#60daca")
        .setBarBackgroundColor("#ffffff")
        .addItem(new BottomNavigationItem(R.drawable.home , "home"))
        .addItem(new BottomNavigationItem(R.drawable.location , "location"))
        .addItem(new BottomNavigationItem(R.drawable.like , "like"))
        .addItem(new BottomNavigationItem(R.drawable.person , "person"))
        .setFirstSelectedPosition(0)
                .initialise();
        bar.setTabSelectedListener(this) ;
        /**
         *因为首次进入不会主动回调选中页面的监听，所以这里进行手动调用一遍，初始化第一个页面
         */
        onTabSelected(0);
    }

    @Override
    public void onTabSelected(int position) {

        transaction = getSupportFragmentManager().beginTransaction() ;

        switch (position)
        {
            case 0:
                if (oneFragment == null)
                {
                    oneFragment = new OneFragment() ;
                }
                transaction.replace(R.id.fm_fraglayout , oneFragment) ;
                break ;

            case 1 :
                if (twoFragment == null){
                    twoFragment = new TwoFragment() ;
                }
                transaction.replace(R.id.fm_fraglayout , twoFragment) ;
                break ;

            case 2:
                if (threeFragment == null)
                {
                    threeFragment = new ThreeFragment() ;
                }
                transaction.replace(R.id.fm_fraglayout , threeFragment) ;
                break ;
            case 3:
                if (fourFragment == null)
                {
                    fourFragment = new FourFragment() ;
                }
                transaction.replace(R.id.fm_fraglayout , fourFragment) ;
                break ;

        }

        transaction.commit() ;
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}

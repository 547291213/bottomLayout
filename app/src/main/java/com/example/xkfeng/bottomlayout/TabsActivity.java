package com.example.xkfeng.bottomlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.FrameStats;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xkfeng.bottomlayout.TabFragment.FragmentAdapter;
import com.example.xkfeng.bottomlayout.TabFragment.TablayoutFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by initializing on 2018/7/4.
 */

public class TabsActivity extends AppCompatActivity {

    private Toolbar toolbar ;
    private TabLayout tabLayout ;
    private ViewPager viewPager ;
    private List<String> titles ;
    private List<Fragment> fragments ;
    private int[] tabIcons = {
            R.drawable.home ,
            R.drawable.location ,
            R.drawable.like ,
            R.drawable.person
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablayout);
        initView() ;
        initValue();
        initEvent();
        /*
           默认启动后，当前界面的tab没有选中效果，下面的方法，可以设置出效果
         */
        viewPager.setCurrentItem(1);

        viewPager.setCurrentItem(0);

    }

    /*
      注意：
          tabLayout本来有自己OnTabSelectedLsitener事件。用于追踪用户的点击并且配合ViewPaper做出相应的页面切换。
          这里的重写会覆盖掉原有的事件，所以也就要求我们自己实现点击tabLayout item完成viewPager的切换。
     */
    private void initEvent()
    {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Log.i("TabsActivity" , "onTabSelect") ;
                View customView = tab.getCustomView();
                TextView tabText = (TextView) customView.findViewById(R.id.tv_tabtext);
                ImageView tabIcon = (ImageView) customView.findViewById(R.id.iv_tabimage);
                tabText.setTextColor(ContextCompat.getColor(TabsActivity.this, R.color.colorPrimary));
                String s = tabText.getText().toString();
                if ("home".equals(s)) {
                    tabIcon.setImageResource(R.drawable.home_fill);
                    viewPager.setCurrentItem(0);
                } else if ("location".equals(s)) {
                    tabIcon.setImageResource(R.drawable.location_fill);
                    viewPager.setCurrentItem(1);
                } else if ("like".equals(s)) {
                    viewPager.setCurrentItem(2);
                    tabIcon.setImageResource(R.drawable.like_fill);
                } else if ("person".equals(s)) {
                    viewPager.setCurrentItem(3);
                    tabIcon.setImageResource(R.drawable.person_fill);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Log.i("TabsActivity" , "onTabUnSelect") ;
                View customView = tab.getCustomView();
                TextView tabText = (TextView) customView.findViewById(R.id.tv_tabtext);
                ImageView tabIcon = (ImageView) customView.findViewById(R.id.iv_tabimage);
                tabText.setTextColor(ContextCompat.getColor(TabsActivity.this, R.color.black_1));
                String s = tabText.getText().toString();
                if ("home".equals(s)) {
                    tabIcon.setImageResource(R.drawable.home);
                } else if ("location".equals(s)) {
                    tabIcon.setImageResource(R.drawable.location);
                } else if ("like".equals(s)) {
                    tabIcon.setImageResource(R.drawable.like);
                } else if ("person".equals(s)) {
                    tabIcon.setImageResource(R.drawable.person);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


    private void initView()
    {
        toolbar = (Toolbar)findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.viewpager) ;
        tabLayout = (TabLayout) findViewById(R.id.tabs) ;



    }

    private void initValue()
    {
        fragments = new ArrayList<Fragment>() ;
        fragments.add(TablayoutFragment.newInstance("home")) ;
        fragments.add(TablayoutFragment.newInstance("location")) ;
        fragments.add(TablayoutFragment.newInstance("like")) ;
        fragments.add(TablayoutFragment.newInstance("person")) ;
        titles = new ArrayList<>() ;
        titles.add("home") ;
        titles.add("location") ;
        titles.add("like") ;
        titles.add("person") ;
        FragmentAdapter fragmentAdapter = new FragmentAdapter(getSupportFragmentManager() , fragments , titles) ;
        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(fragmentAdapter);


        setupTabIcons();
    }

    private void setupTabIcons(){
        tabLayout.getTabAt(0).setCustomView(getTabView(0));

        tabLayout.getTabAt(1).setCustomView(getTabView(1));

        tabLayout.getTabAt(2).setCustomView(getTabView(2));

        tabLayout.getTabAt(3).setCustomView(getTabView(3));
    }

    private View getTabView(int position){
        View view = LayoutInflater.from(this).inflate(R.layout.tab_item , null) ;
        TextView textView = (TextView)view.findViewById(R.id.tv_tabtext) ;
        textView.setText(titles.get(position));

        ImageView imageView = (ImageView)view.findViewById(R.id.iv_tabimage) ;
        imageView.setImageResource(tabIcons[position]);
        return view ;
    }



}

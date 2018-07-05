package com.example.xkfeng.bottomlayout;

import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xkfeng.bottomlayout.Fragment.FourFragment;
import com.example.xkfeng.bottomlayout.Fragment.OneFragment;
import com.example.xkfeng.bottomlayout.Fragment.ThreeFragment;
import com.example.xkfeng.bottomlayout.Fragment.TwoFragment;

/**
 * Created by initializing on 2018/7/4.
 */

public class TextViewActivity extends AppCompatActivity implements TextView.OnClickListener{


    private LinearLayout linearLayout ;
    private OneFragment oneFragment ;
    private TwoFragment twoFragment ;
    private ThreeFragment threeFragment ;
    private FourFragment fourFragment ;
    private android.support.v4.app.FragmentTransaction transaction ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textview_layout);
        linearLayout =  (LinearLayout)findViewById(R.id.ll_layout) ;
        for (int i = 0 ; i< linearLayout.getChildCount() ; i++)
        {
            linearLayout.getChildAt(i).setOnClickListener(this);
        }

        transaction = getSupportFragmentManager().beginTransaction() ;
        oneFragment = new OneFragment() ;
        transaction.replace(R.id.fm_fraglayout , oneFragment) ;
        transaction.commit();

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    public void onClick(View v) {
        resetTabState();
        transaction = getSupportFragmentManager().beginTransaction() ;
        switch (v.getId()){
            case R.id.tv_home :
                transaction.replace(R.id.fm_fraglayout , oneFragment) ;
                setTabState((TextView) linearLayout.getChildAt(0), R.drawable.home_fill);
                break;

            case R.id.tv_location :

                if (twoFragment == null)
                {
                    twoFragment = new TwoFragment() ;
                }
                setTabState((TextView) linearLayout.getChildAt(1), R.drawable.like_fill);
                transaction.replace(R.id.fm_fraglayout , twoFragment) ;
                break ;

            case R.id.tv_like :
                if (threeFragment == null)
                {
                    threeFragment = new ThreeFragment() ;
                }
                setTabState((TextView) linearLayout.getChildAt(2), R.drawable.location_fill);
                transaction.replace(R.id.fm_fraglayout , threeFragment) ;

                break ;

            case R.id.tv_person :

                if (fourFragment == null)
                {
                    fourFragment = new FourFragment() ;
                }
                setTabState((TextView) linearLayout.getChildAt(3), R.drawable.person_fill);
                transaction.replace(R.id.fm_fraglayout , fourFragment) ;
                break;
        }

        transaction.commit() ;


    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void setTabState(TextView textView , int image )
    {
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(0 ,image , 0 , 0);


    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    private void resetTabState() {
        setTabState((TextView) linearLayout.getChildAt(0), R.drawable.home);
        setTabState((TextView) linearLayout.getChildAt(1), R.drawable.location);
        setTabState((TextView) linearLayout.getChildAt(2), R.drawable.like);
        setTabState((TextView) linearLayout.getChildAt(3), R.drawable.person);

    }
}

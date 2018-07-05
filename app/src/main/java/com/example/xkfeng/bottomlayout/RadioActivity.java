package com.example.xkfeng.bottomlayout;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.xkfeng.bottomlayout.Fragment.FourFragment;
import com.example.xkfeng.bottomlayout.Fragment.OneFragment;
import com.example.xkfeng.bottomlayout.Fragment.ThreeFragment;
import com.example.xkfeng.bottomlayout.Fragment.TwoFragment;

public class RadioActivity extends AppCompatActivity implements RadioButton.OnClickListener{

    private RadioGroup radioGroup ;
    private OneFragment oneFragment ;
    private TwoFragment twoFragment ;
    private ThreeFragment threeFragment ;
    private FourFragment fourFragment ;
    private FrameLayout frameLayout ;
    private FragmentTransaction transaction ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.radio_layout);

        radioGroup = (RadioGroup)findViewById(R.id.rg_layout) ;

        frameLayout = (FrameLayout)findViewById(R.id.fm_fraglayout) ;
        oneFragment = new OneFragment() ;
        transaction =  getSupportFragmentManager().beginTransaction() ;
        transaction.replace(R.id.fm_fraglayout , oneFragment) ;
        transaction.commit() ;
        /*
           为每个单选按钮设置点击事件
         */
        for (int i = 0 ;i < radioGroup.getChildCount() ; i++)
        {
            radioGroup.getChildAt(i).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        final int count = radioGroup.getChildCount() ;

        transaction = getSupportFragmentManager().beginTransaction() ;
        for (int i = 0 ; i< count ; i++)
        {
            if (v.getId() == radioGroup.getChildAt(i).getId())
            {
                //设置fragmenttr
                if (i == 0 )
                {
                    transaction.replace(R.id.fm_fraglayout , oneFragment) ;
                }
                else if ( i == 1)
                {
                    if (twoFragment == null){
                        twoFragment = new TwoFragment() ;
                    }
                    transaction.replace(R.id.fm_fraglayout , twoFragment) ;
                }
                else if ( i == 2 )
                {
                    if (threeFragment == null)
                    {
                        threeFragment = new ThreeFragment() ;
                    }
                    transaction.replace(R.id.fm_fraglayout , threeFragment) ;
                }
                else if (i == 3)
                {
                    if (fourFragment == null)
                    {
                        fourFragment = new FourFragment() ;
                    }
                    transaction.replace(R.id.fm_fraglayout ,fourFragment);
                }
            }
        }
        transaction.commit() ;
    }
}

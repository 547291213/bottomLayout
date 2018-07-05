package com.example.xkfeng.bottomlayout.TabFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xkfeng.bottomlayout.R;

/**
 * Created by initializing on 2018/7/4.
 */

public class TablayoutFragment extends Fragment {


    private View view ;
    public final static String TYPE = "type" ;
    private TextView textView  ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_layout , container , false) ;
        textView = (TextView) view.findViewById(R.id.tx_fragShowText) ;
        textView.setText(getArguments().getString(TYPE , "DEFAULT"));

        return view;
    }

    public static TablayoutFragment newInstance(String text)
    {
        TablayoutFragment fragment = new TablayoutFragment() ;
        Bundle bundle = new Bundle() ;
        bundle.putString(TYPE , text);
        fragment.setArguments(bundle);
        return fragment ;
    }
}

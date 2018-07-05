package com.example.xkfeng.bottomlayout.Fragment;

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

public class FourFragment extends Fragment {
    private TextView textView ;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_layout , container , false) ;
        textView = (TextView)view.findViewById(R.id.tx_fragShowText) ;
        textView.setText("FOUR");
        return view ;
    }
}

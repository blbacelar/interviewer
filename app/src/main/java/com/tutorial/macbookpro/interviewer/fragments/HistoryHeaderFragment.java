package com.tutorial.macbookpro.interviewer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tutorial.macbookpro.interviewer.R;

/**
 * Created by macbookpro on 2017-11-02.
 */

public class HistoryHeaderFragment extends Fragment {

    private TextView txtHeader;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.history_layout_header,container,false);

        txtHeader = view.findViewById(R.id.txtHistoryHeader);

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    @Override
    public void onDestroyView(){
        super.onDestroyView();
    }
}

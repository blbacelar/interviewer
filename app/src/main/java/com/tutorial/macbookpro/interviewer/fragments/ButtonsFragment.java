package com.tutorial.macbookpro.interviewer.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tutorial.macbookpro.interviewer.R;

/**
 * Created by macbookpro on 2017-10-30.
 */

public class ButtonsFragment extends Fragment {

    private Button btnResult,btnHistory,btnLogout;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_button,container,false);

        btnResult = (Button) view.findViewById(R.id.btnResult);
        btnHistory = (Button) view.findViewById(R.id.btnHistory);
        btnLogout = (Button) view.findViewById(R.id.btnLogout);

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

package com.tutorial.macbookpro.interviewer.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.tutorial.macbookpro.interviewer.R;

/**
 * Created by macbookpro on 2017-10-30.
 */

public class TopicFragment extends Fragment {

    private RadioButton rdbJava,rdbSql;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_topic,container,false);

        rdbJava = (RadioButton) view.findViewById(R.id.rdbJava);
        rdbSql = (RadioButton) view.findViewById(R.id.rdbSQL);

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

package com.tutorial.macbookpro.interviewer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tutorial.macbookpro.interviewer.R;

/**
 * Created by macbookpro on 2017-11-02.
 */

public class ButtonHistoryFragment extends Fragment {

    private Button btnInterview;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_button_history,container,false);

        btnInterview = view.findViewById(R.id.btnInterview);

        btnInterview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment fragment = new QuestionFragment();
                moveToFragment(fragment);
            }
        });

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void moveToFragment(Fragment fragment) {

        getActivity().getSupportFragmentManager().beginTransaction().remove(new ButtonHistoryFragment()).commit();
        getActivity().getSupportFragmentManager().popBackStack();

        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_frame, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();

    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
    }
}

package com.tutorial.macbookpro.interviewer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.tutorial.macbookpro.interviewer.R;
import com.tutorial.macbookpro.interviewer.manager.GlobalBus;
import com.tutorial.macbookpro.interviewer.model.AnswerCollectionResponse;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by macbookpro on 2017-11-01.
 */

public class ResultFragment extends Fragment {

    TextView txtDate ;
    TextView txtScore ;
    View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view != null) {
            ViewGroup parent = (ViewGroup) view.getParent();
            if (parent != null)
                parent.removeView(view);
        }
        try {
            view = inflater.inflate(R.layout.fragment_result,container,false);
        } catch (InflateException e) {
        /* map is already there, just return view as it is */
        }

        txtDate = view.findViewById(R.id.edtDate);
        txtScore = view.findViewById(R.id.edtScore);

        Button btnMain = view.findViewById(R.id.btnMain);


        btnMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
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

    @Override
    public void onStart(){
        super.onStart();
        GlobalBus.getBus().register(this);
    }

    private void moveToFragment(Fragment fragment) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_frame, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();

    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void getMessage(AnswerCollectionResponse aResponse) {

        String startDateString = aResponse.getDateTest();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date startDate = null;
        try {
            startDate = df.parse(startDateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        String formattedDate = new SimpleDateFormat("yyyy-MM-dd").format(startDate);
        txtDate.setText("Date: " + formattedDate);
        txtScore.setText(aResponse.getCorrectResponses()+ "/" + aResponse.getTotalQuestions());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        GlobalBus.getBus().unregister(this);
    }

}

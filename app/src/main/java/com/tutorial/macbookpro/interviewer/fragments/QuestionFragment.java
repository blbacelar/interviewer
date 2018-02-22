package com.tutorial.macbookpro.interviewer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.InflateException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import com.tutorial.macbookpro.interviewer.R;
import com.tutorial.macbookpro.interviewer.manager.ApiUtils;
import com.tutorial.macbookpro.interviewer.manager.GlobalBus;
import com.tutorial.macbookpro.interviewer.manager.SOService;
import com.tutorial.macbookpro.interviewer.model.AnswerCollectionEntity;
import com.tutorial.macbookpro.interviewer.model.AnswerCollectionResponse;
import com.tutorial.macbookpro.interviewer.model.AnswerEntity;
import com.tutorial.macbookpro.interviewer.model.HistoryResponse;
import com.tutorial.macbookpro.interviewer.model.InterviewEntity;
import com.tutorial.macbookpro.interviewer.model.InterviewEntityAdapter;
import com.tutorial.macbookpro.interviewer.model.QuestionEntity;
import com.tutorial.macbookpro.interviewer.model.Topic;
import com.tutorial.macbookpro.interviewer.request.HistoryRequestModel;
import com.tutorial.macbookpro.interviewer.request.InterviewRequest;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by macbookpro on 2017-10-31.
 */

public class QuestionFragment extends Fragment implements InterviewEntityAdapter.PostItemListener {

    private InterviewEntityAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private SOService mService;
    private RadioButton rdbJava,rdbSql,rd1,rd2,rd3,rd4;
    private Button btnResult,btnHistory, btnLogout;
    private InterviewEntity interviewEntity;
    private AnswerCollectionEntity answerCollectionEntity;
    private AnswerCollectionResponse answerCollectionResponse;
    private HistoryRequestModel historyRequestModel;
    private HistoryResponse HistoryResponse;
    public static int userId;

    private ArrayList<AnswerEntity> correctAnswer = new ArrayList<>();

    public static View view = null;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userId = MainPageFragment.userEntity.getUserID();
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
            view = inflater.inflate(R.layout.fragment_question, container, false);
        } catch (InflateException e) {
        /* map is already there, just return view as it is */
        }

        rdbJava = view.findViewById(R.id.rdbJava);
        rdbSql = view.findViewById(R.id.rdbSQL);
        rd1 = view.findViewById(R.id.rdb1);
        rd2 = view.findViewById(R.id.rdb2);
        rd3 = view.findViewById(R.id.rdb3);
        rd4 = view.findViewById(R.id.rdb4);

        btnResult = view.findViewById(R.id.btnResult);
        btnHistory = view.findViewById(R.id.btnHistory);
        btnLogout = view.findViewById(R.id.btnLogout);

        mService = ApiUtils.getSOService();
        mRecyclerView = view.findViewById(R.id.rv_question);
        createAdapter(view);

        rdbJava.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAdapter(view);
                loadAnswers("Java");
            }
        });

        rdbSql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAdapter(view);
                loadAnswers("SQL");
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Fragment fragment = new HistoryFragment();
                moveToFragment(fragment);
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                Fragment fragment = new MainPageFragment();
                moveToFragment(fragment);
            }
        });


        // verify the results
        btnResult.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                answerCollectionEntity = new AnswerCollectionEntity(interviewEntity.getInterviewId(), MainPageFragment.userEntity.getUserID(), correctAnswer);
                mService.submitAnswers(answerCollectionEntity).enqueue(new Callback<AnswerCollectionResponse>() {
                    @Override
                    public void onResponse(Call<AnswerCollectionResponse> call, Response<AnswerCollectionResponse> response) {

                        if(response.isSuccessful()) {
                            answerCollectionResponse = response.body();

                            sendMessageToFragment();

                            Fragment fragment = new ResultFragment();
                            moveToFragment(fragment);

                            Log.d("QuestionFragment", "posts loaded from API");
                        }else {
                            int statusCode  = response.code();
                            Log.d("QuestionFragment", "Error Java: " + Integer.toString(statusCode));
                            // handle request errors depending on status code
                        }
                    }

                    @Override
                    public void onFailure(Call<AnswerCollectionResponse> call, Throwable t) {
                        //showErrorMessage();
                        Log.d("QuestionFragment", "error loading from API " + t.getMessage());
                    }
                });
            }
        });
        
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    private void moveToFragment(Fragment fragment) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_frame, fragment, fragment.getClass().getSimpleName()).addToBackStack(null).commit();

    }


    public void sendMessageToFragment(){
        GlobalBus.getBus().postSticky(answerCollectionResponse);
    }

    public void loadAnswers(String type) {
        Log.d("QuestionFragment", "loaded from API");

        InterviewRequest request = new InterviewRequest(Topic.Java);

        if(type == "Java"){
            mService.getQuestionsJava(request).enqueue(new Callback<InterviewEntity>() {
                @Override
                public void onResponse(Call<InterviewEntity> call, Response<InterviewEntity> response) {

                    if(response.isSuccessful()) {
                        interviewEntity = response.body();
                        mAdapter.updateQuestions(interviewEntity.getQuestion());
                        Log.d("QuestionFragment", "posts loaded from API");
                    }else {
                        int statusCode  = response.code();
                        Log.d("QuestionFragment", "Error Java: " + Integer.toString(statusCode));
                        // handle request errors depending on status code
                    }
                }

                @Override
                public void onFailure(Call<InterviewEntity> call, Throwable t) {
                    //showErrorMessage();
                    Log.d("QuestionFragment", "error loading from API " + t.getMessage());
                }
            });
        } else {
            mService.getQuestionsSQL(request).enqueue(new Callback<InterviewEntity>() {
                @Override
                public void onResponse(Call<InterviewEntity> call, Response<InterviewEntity> response) {

                    if(response.isSuccessful()) {
                        interviewEntity = response.body();
                        mAdapter.updateQuestions(interviewEntity.getQuestion());
                        Log.d("QuestionFragment", "posts loaded from API");
                    }else {
                        int statusCode  = response.code();
                        Log.d("QuestionFragment", "Error SQL: " + Integer.toString(statusCode));
                        // handle request errors depending on status code
                    }
                }

                @Override
                public void onFailure(Call<InterviewEntity> call, Throwable t) {
                    //showErrorMessage();
                    Log.d("QuestionFragment", "error loading from API " + t.getMessage());
                }
            });
        }
    }

    @Override
    public void onOption1(int id) {

        correctAnswer.add(new AnswerEntity(id,'A'));

    }

    @Override
    public void onOption2(int id) {
        correctAnswer.add(new AnswerEntity(id,'B'));

    }

    @Override
    public void onOption3(int id) {
        correctAnswer.add(new AnswerEntity(id,'C'));

    }

    @Override
    public void onOption4(int id) {
        correctAnswer.add(new AnswerEntity(id,'D'));

    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
    }

    public void createAdapter(View view){
        mAdapter = new InterviewEntityAdapter(getContext(), new ArrayList<QuestionEntity>(1));
        mAdapter.setCustomButtonListner(QuestionFragment.this);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
    }

}

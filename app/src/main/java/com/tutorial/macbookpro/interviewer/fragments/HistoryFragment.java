package com.tutorial.macbookpro.interviewer.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tutorial.macbookpro.interviewer.R;
import com.tutorial.macbookpro.interviewer.manager.ApiUtils;
import com.tutorial.macbookpro.interviewer.manager.SOService;
import com.tutorial.macbookpro.interviewer.model.HistoryAdapter;
import com.tutorial.macbookpro.interviewer.model.HistoryEntity;
import com.tutorial.macbookpro.interviewer.model.HistoryResponse;
import com.tutorial.macbookpro.interviewer.request.HistoryRequestModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by macbookpro on 2017-11-02.
 */

public class HistoryFragment extends Fragment {

    private HistoryAdapter mAdapter;
    TextView txtTopic,txtDate,txtScore;
    private RecyclerView mRecyclerView;
    private SOService mService;

    private HistoryRequestModel historyRequestModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        historyRequestModel = new HistoryRequestModel(QuestionFragment.userId);

        mService = ApiUtils.getSOService();
        mService.getHistory(historyRequestModel).enqueue(new Callback<HistoryResponse>() {
            @Override
            public void onResponse(Call<HistoryResponse> call, Response<HistoryResponse> response) {

                if(response.isSuccessful()) {

                    mAdapter.updateHistory(response.body().getHistoryEntities());
                    Log.d("HistoryFragment", "history loaded from API 1");


                    Log.d("HistoryFragment", "history loaded from API 2");
                }else {
                    int statusCode  = response.code();
                    Log.d("HistoryFragment", "Error Java: " + Integer.toString(statusCode));
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<HistoryResponse> call, Throwable t) {
                //showErrorMessage();
                Log.d("HistoryFragment", "error loading from API " + t.getMessage());
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history,container,false);

        Log.d("HistoryFragment", "history on create View");

        txtTopic = view.findViewById(R.id.txtTopic);
        txtDate = view.findViewById(R.id.txtDate);
        txtScore = view.findViewById(R.id.txtScore);

        mRecyclerView = view.findViewById(R.id.rv_history);
        createAdapter(view);

        return view;
    }

    @Override
    public void onPause() {
        super.onPause();
    }


    public void createAdapter(View view){
        mAdapter = new HistoryAdapter(getContext(), new ArrayList<HistoryEntity>(1));

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setHasFixedSize(true);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(view.getContext(), DividerItemDecoration.VERTICAL);
        mRecyclerView.addItemDecoration(itemDecoration);
    }

    @Override
    public void onDestroyView(){
        super.onDestroyView();
    }

}

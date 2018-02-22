package com.tutorial.macbookpro.interviewer.manager;

import com.tutorial.macbookpro.interviewer.model.AnswerCollectionEntity;
import com.tutorial.macbookpro.interviewer.model.AnswerCollectionResponse;
import com.tutorial.macbookpro.interviewer.model.HistoryResponse;
import com.tutorial.macbookpro.interviewer.model.InterviewEntity;
import com.tutorial.macbookpro.interviewer.model.UserEntity;
import com.tutorial.macbookpro.interviewer.request.HistoryRequestModel;
import com.tutorial.macbookpro.interviewer.request.InterviewRequest;
import com.tutorial.macbookpro.interviewer.request.LoginRequest;
import com.tutorial.macbookpro.interviewer.request.RegisterRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SOService {

    @POST("interview/topics/Java")
    Call<InterviewEntity> getQuestionsJava(@Body InterviewRequest interviewRequest);

    @POST("interview/topics/SQL")
    Call<InterviewEntity> getQuestionsSQL(@Body InterviewRequest interviewRequest);

    @POST("interview/login")
    Call<UserEntity> login(@Body LoginRequest loginRequest);

    @POST("interview/users")
    Call<UserEntity> register(@Body RegisterRequest registerRequest);

    @POST("interview")
    Call<AnswerCollectionResponse> submitAnswers(@Body AnswerCollectionEntity answerCollectionEntity);

    @POST("interview/history/user")
    Call<HistoryResponse> getHistory(@Body HistoryRequestModel historyRequestModel);

}

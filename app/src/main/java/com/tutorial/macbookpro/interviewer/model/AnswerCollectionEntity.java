package com.tutorial.macbookpro.interviewer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class AnswerCollectionEntity {

    @SerializedName("interviewId")
    @Expose
	Integer interviewId;

    @SerializedName("userId")
    @Expose
    Integer userId;

    @SerializedName("answers")
    @Expose
	ArrayList<AnswerEntity> answers = new ArrayList<>();
	
	public AnswerCollectionEntity() {
		super();
	}

	public AnswerCollectionEntity(Integer interviewId, Integer userId, ArrayList<AnswerEntity> answers) {
		super();
		this.interviewId = interviewId;
		this.userId = userId;
		this.answers = answers;
	}

	public Integer getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Integer interviewId) {
		this.interviewId = interviewId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public ArrayList<AnswerEntity> getanswers() {
		return answers;
	}

	public void setanswers(ArrayList<AnswerEntity> answers) {
		this.answers = answers;
	}

}

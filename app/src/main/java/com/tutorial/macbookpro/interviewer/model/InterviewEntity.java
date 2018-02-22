package com.tutorial.macbookpro.interviewer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;


public class InterviewEntity  {

    @SerializedName("interviewId")
    @Expose
	Integer interviewId;
    @SerializedName("question")
    @Expose
	ArrayList<QuestionEntity> question = null;

    @SerializedName("topic")
    @Expose
    Topic topic;

    @SerializedName("duration")
    @Expose
	Float duration;

	public InterviewEntity() {
	}

	public InterviewEntity(Integer interviewId, ArrayList<QuestionEntity> question, Topic topic, Float duration) {
		super();
		this.interviewId = interviewId;
		this.question = question;
		this.topic = topic;
		this.duration = duration;
	}
	
	public Integer getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Integer interviewId) {
		this.interviewId = interviewId;
	}

	public ArrayList<QuestionEntity> getQuestion() {
		return question;
	}

	public void setQuestion(ArrayList<QuestionEntity> question) {
		this.question = question;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}

	public Float getDuration() {
		return duration;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

}

package com.tutorial.macbookpro.interviewer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnswerEntity {

    @SerializedName("questionID")
    @Expose
	Integer questionID;

    @SerializedName("answer")
    @Expose
    Character answer;
	
	public AnswerEntity() {
		super();
	}
	public AnswerEntity(Integer questionID, Character answer) {
		super();
		this.questionID = questionID;
		this.answer = answer;
	}
	public Integer getQuestionID() {
		return questionID;
	}
	public void setQuestionID(Integer questionID) {
		this.questionID = questionID;
	}
	public Character getAnswer() {
		return answer;
	}
	public void setAnswer(Character answer) {
		this.answer = answer;
	}
	
	

}

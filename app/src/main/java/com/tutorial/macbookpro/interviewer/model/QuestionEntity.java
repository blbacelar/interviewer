package com.tutorial.macbookpro.interviewer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class QuestionEntity {

    @SerializedName("questionId")
    @Expose
	Integer questionId;

    @SerializedName("description")
    @Expose
	String description;

    @SerializedName("difficulty")
    @Expose
	Integer difficulty;

    @SerializedName("option")
    @Expose
	ArrayList<String> option = new ArrayList<>();
	
	public QuestionEntity() {
		super();
	}


	public QuestionEntity(Integer questionId, String description, Integer difficulty, ArrayList<String> option) {
		super();
		this.questionId = questionId;
		this.description = description;
		this.difficulty = difficulty;
		this.option = option;
	}

	
	public Integer getQuestionId() {
		return questionId;
	}


	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(Integer difficulty) {
		this.difficulty = difficulty;
	}

	public ArrayList<String> getOption() {
		return option;
	}

	public void setOption(ArrayList<String> option) {
		this.option = option;
	}
	
}

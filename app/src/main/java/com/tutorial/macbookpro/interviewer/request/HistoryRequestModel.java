package com.tutorial.macbookpro.interviewer.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HistoryRequestModel {

    @SerializedName("userId")
    @Expose
	Integer userId;

	
	public HistoryRequestModel() {
		super();
	}

	public HistoryRequestModel(Integer userId) {
		super();
		this.userId = userId;
	}

	public Integer getuserId() {
		return userId;
	}

	public void setuserId(Integer userId) {
		this.userId = userId;
	}

}

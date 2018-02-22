package com.tutorial.macbookpro.interviewer.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bacelar on 2017-08-01.
 */
public class LoginRequest {

    @SerializedName("passWord")
    @Expose
    private String passWord;

    @SerializedName("userName")
    @Expose
    private String userName;

    public LoginRequest() {
	}

	public LoginRequest(String passWord, String userName) {
        this.passWord = passWord;
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}


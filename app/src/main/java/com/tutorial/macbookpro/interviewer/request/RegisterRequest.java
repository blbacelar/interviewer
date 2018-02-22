package com.tutorial.macbookpro.interviewer.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by bacelar on 2017-08-01.
 */
public class RegisterRequest {


    @SerializedName("firstName")
    @Expose
    private String firstName;

    @SerializedName("lastName")
    @Expose
    private String lastName;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("userName")
    @Expose
    private String userName;

    @SerializedName("passWord")
    @Expose
    private String passWord;
    

    public RegisterRequest() {
		super();
	}

	public RegisterRequest(String firstName, String lastName, String country, String userName, String passWord) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.country = country;
        this.userName = userName;
        this.passWord = passWord;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}

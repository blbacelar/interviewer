package com.tutorial.macbookpro.interviewer.model;

/**
 * Created by bacelar on 2017-08-01.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserEntity {

    @SerializedName("authtoken")
    @Expose
    private String authtoken;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("firstName")
    @Expose
    private String firstName;
    @SerializedName("joinDate")
    @Expose
    private String joinDate;
    @SerializedName("lastName")
    @Expose
    private String lastName;
    @SerializedName("passWord")
    @Expose
    private String passWord;
    @SerializedName("userID")
    @Expose
    private Integer userID;
    @SerializedName("userName")
    @Expose
    private String userName;

    /**
     * No args constructor for use in serialization
     *
     */
    public UserEntity() {
    }

    /**
     *
     * @param joinDate
     * @param userID
     * @param lastName
     * @param authtoken
     * @param userName
     * @param firstName
     * @param passWord
     * @param country
     */
    public UserEntity(String authtoken, String country, String firstName, String joinDate, String lastName, String passWord, Integer userID, String userName) {
        super();
        this.authtoken = authtoken;
        this.country = country;
        this.firstName = firstName;
        this.joinDate = joinDate;
        this.lastName = lastName;
        this.passWord = passWord;
        this.userID = userID;
        this.userName = userName;
    }

    public String getAuthtoken() {
        return authtoken;
    }

    public void setAuthtoken(String authtoken) {
        this.authtoken = authtoken;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
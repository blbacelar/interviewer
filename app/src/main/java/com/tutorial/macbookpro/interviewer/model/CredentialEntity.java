package com.tutorial.macbookpro.interviewer.model;

/**
 * Created by bacelar on 2017-08-01.
 */
public class CredentialEntity {

    private String passWord;
    private String userName;

    public CredentialEntity(String passWord, String userName) {
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


package com.tutorial.macbookpro.interviewer.model;

import java.util.Date;
import java.util.UUID;

public class ProfileEntity {
	
	UserEntity userEntity;
	Integer userID;
	Date creationDate;
	String authenticationToken;	
	
	public ProfileEntity(UserEntity userEntity, Integer userID, Date creationDate, String authenticationToken) {
		super();
		this.userEntity = userEntity;
		this.userID = userID;
		this.creationDate = creationDate;
		this.authenticationToken = authenticationToken;
	}
	
	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getAuthenticationToken() {
		return authenticationToken;
	}
	public void setAuthenticationToken(String authenticationToken) {
		this.authenticationToken = authenticationToken;
	}
	
	public static String generateAuthToken() {
		@SuppressWarnings("deprecation")
		String token = UUID.randomUUID().toString().toUpperCase() 
	            + "|"
	            + new Date().getSeconds();
		
		return token;
	}

}

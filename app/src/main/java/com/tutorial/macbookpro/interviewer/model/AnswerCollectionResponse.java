
package com.tutorial.macbookpro.interviewer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AnswerCollectionResponse {

    @SerializedName("correctResponses")
    @Expose
    private Integer correctResponses;
    @SerializedName("dateTest")
    @Expose
    private String dateTest;
    @SerializedName("interviewId")
    @Expose
    private Integer interviewId;
    @SerializedName("skippedResponses")
    @Expose
    private Integer skippedResponses;
    @SerializedName("totalQuestions")
    @Expose
    private Integer totalQuestions;
    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("wrongResponses")
    @Expose
    private Integer wrongResponses;

    /**
     * No args constructor for use in serialization
     * 
     */
    public AnswerCollectionResponse() {
    }

    /**
     * 
     * @param correctResponses
     * @param skippedResponses
     * @param userId
     * @param wrongResponses
     * @param dateTest
     * @param totalQuestions
     * @param interviewId
     */
    public AnswerCollectionResponse(Integer correctResponses, String dateTest, Integer interviewId, Integer skippedResponses, Integer totalQuestions, Integer userId, Integer wrongResponses) {
        super();
        this.correctResponses = correctResponses;
        this.dateTest = dateTest;
        this.interviewId = interviewId;
        this.skippedResponses = skippedResponses;
        this.totalQuestions = totalQuestions;
        this.userId = userId;
        this.wrongResponses = wrongResponses;
    }

    public Integer getCorrectResponses() {
        return correctResponses;
    }

    public void setCorrectResponses(Integer correctResponses) {
        this.correctResponses = correctResponses;
    }

    public String getDateTest() {
        return dateTest;
    }

    public void setDateTest(String dateTest) {
        this.dateTest = dateTest;
    }

    public Integer getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(Integer interviewId) {
        this.interviewId = interviewId;
    }

    public Integer getSkippedResponses() {
        return skippedResponses;
    }

    public void setSkippedResponses(Integer skippedResponses) {
        this.skippedResponses = skippedResponses;
    }

    public Integer getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(Integer totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getWrongResponses() {
        return wrongResponses;
    }

    public void setWrongResponses(Integer wrongResponses) {
        this.wrongResponses = wrongResponses;
    }

}

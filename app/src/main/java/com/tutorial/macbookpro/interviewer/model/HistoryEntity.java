
package com.tutorial.macbookpro.interviewer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HistoryEntity {

    @SerializedName("correct")
    @Expose
    private Integer correct;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("topic")
    @Expose
    private String topic;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("userId")
    @Expose
    private Integer userId;

    /**
     * No args constructor for use in serialization
     * 
     */
    public HistoryEntity() {
    }

    /**
     * 
     * @param total
     * @param topic
     * @param correct
     * @param userId
     * @param date
     */
    public HistoryEntity(Integer correct, String date, String topic, Integer total, Integer userId) {
        super();
        this.correct = correct;
        this.date = date;
        this.topic = topic;
        this.total = total;
        this.userId = userId;
    }

    public Integer getCorrect() {
        return correct;
    }

    public void setCorrect(Integer correct) {
        this.correct = correct;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}

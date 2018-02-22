package com.tutorial.macbookpro.interviewer.request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.tutorial.macbookpro.interviewer.model.Topic;

/**
 * Created by macbookpro on 2017-10-30.
 */

public class InterviewRequest {

    @SerializedName("topic")
    @Expose
    Topic topic;


    public InterviewRequest(Topic topic) {
        this.topic = topic;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}

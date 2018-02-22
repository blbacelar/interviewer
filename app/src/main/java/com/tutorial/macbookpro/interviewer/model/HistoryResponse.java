
package com.tutorial.macbookpro.interviewer.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class HistoryResponse {

    @SerializedName("historyEntities")
    @Expose
    private ArrayList<HistoryEntity> historyEntities = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public HistoryResponse() {
    }

    /**
     * 
     * @param historyEntities
     */
    public HistoryResponse(ArrayList<HistoryEntity> historyEntities) {
        super();
        this.historyEntities = historyEntities;
    }

    public ArrayList<HistoryEntity> getHistoryEntities() {
        return historyEntities;
    }

    public void setHistoryEntities(ArrayList<HistoryEntity> historyEntities) {
        this.historyEntities = historyEntities;
    }

}

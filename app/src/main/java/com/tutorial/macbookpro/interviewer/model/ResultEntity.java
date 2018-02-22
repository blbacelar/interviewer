package com.tutorial.macbookpro.interviewer.model;

import java.util.Date;

public class ResultEntity {
	Integer interviewId;
	Float score;
	Integer correct;
	Integer wrong;
	Integer skipped;
	Integer total;
	Date date;
	
	public ResultEntity(Integer interviewId, Float score, Integer correct, Integer wrong, Integer skipped,
			Integer total, Date date) {
		super();
		this.interviewId = interviewId;
		this.score = score;
		this.correct = correct;
		this.wrong = wrong;
		this.skipped = skipped;
		this.total = total;
		this.date = date;
	}

	public Integer getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Integer interviewId) {
		this.interviewId = interviewId;
	}

	public Float getScore() {
		return (float) ((getCorrect()*100)/getTotal());
	}

	public void setScore(Float score) {
		this.score = score;
	}

	public Integer getCorrect() {
		return correct;
	}

	public void setCorrect(Integer correct) {
		this.correct = correct;
	}

	public Integer getWrong() {
		return wrong;
	}

	public void setWrong(Integer wrong) {
		this.wrong = wrong;
	}

	public Integer getSkipped() {
		return skipped;
	}

	public void setSkipped(Integer skipped) {
		this.skipped = skipped;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}

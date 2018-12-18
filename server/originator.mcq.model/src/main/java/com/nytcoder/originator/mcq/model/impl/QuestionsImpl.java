package com.nytcoder.originator.mcq.model.impl;

import com.nytcoder.originator.mcq.model.Questions;

public class QuestionsImpl implements Questions{
	private Long questionId;
	private String Question;
	private Long typeId;
	private String answer;
	private Boolean isImage;
	private Long subjectId;
	@Override
	public Long getQuestionId() {
		return questionId;
	}
	@Override
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
	@Override
	public String getQuestion() {
		return Question;
	}
	@Override
	public void setQuestion(String question) {
		Question = question;
	}
	@Override
	public Long getTypeId() {
		return typeId;
	}
	@Override
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	@Override
	public String getAnswer() {
		return answer;
	}
	@Override
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	@Override
	public Boolean getIsImage() {
		return isImage;
	}
	@Override
	public void setIsImage(Boolean isImage) {
		this.isImage = isImage;
	}
	@Override
	public Long getSubjectId() {
		return subjectId;
	}
	@Override
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	
}

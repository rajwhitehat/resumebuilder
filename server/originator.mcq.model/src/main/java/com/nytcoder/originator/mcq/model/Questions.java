package com.nytcoder.originator.mcq.model;

public interface Questions {

	public Long getQuestionId();

	public void setSubjectId(Long subjectId);

	public Long getSubjectId();

	public void setIsImage(Boolean isImage);

	public Boolean getIsImage();

	public void setAnswer(String answer);

	public String getAnswer();

	public void setTypeId(Long typeId);

	public Long getTypeId();

	public void setQuestion(String question);

	public String getQuestion();

	public void setQuestionId(Long questionId);

}

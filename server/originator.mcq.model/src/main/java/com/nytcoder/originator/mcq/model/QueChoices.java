package com.nytcoder.originator.mcq.model;

public interface QueChoices {

	public Long getChoiceId();

	public void setChoiceId(Long choiceId);

	public String getChoice();

	public void setChoice(String choice);

	public Boolean getIsImage();

	public Long getQuestionId();

	public void setIsImage(Boolean isImage);

	public void setQuestionId(Long questionId);

}

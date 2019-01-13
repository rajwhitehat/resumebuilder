package com.nytcoder.originator.mcq.model;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = QueChoiceDto.class)
public interface QueChoiceDto {

	public void setChoices(List<ChoiceDto> choices);

	public List<ChoiceDto> getChoices();

	public void setTypeId(Long typeId);

	public Long getTypeId();

	public void setIsImage(Boolean isImage);

	public Boolean getIsImage();

	public void setQuestion(String question);

	public String getQuestion();

	public void setQuestionId(Long questionId);

	public Long getQuestionId();

}

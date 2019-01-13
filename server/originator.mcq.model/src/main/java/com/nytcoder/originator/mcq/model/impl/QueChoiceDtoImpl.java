package com.nytcoder.originator.mcq.model.impl;

import java.util.List;

import com.nytcoder.originator.mcq.model.ChoiceDto;
import com.nytcoder.originator.mcq.model.QueChoiceDto;

public class QueChoiceDtoImpl implements QueChoiceDto {

	private Long questionId;
	private String Question;
	private Boolean isImage;
	private Long typeId;
	private List<ChoiceDto> choices;

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
	public Boolean getIsImage() {
		return isImage;
	}

	@Override
	public void setIsImage(Boolean isImage) {
		this.isImage = isImage;
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
	public List<ChoiceDto> getChoices() {
		return choices;
	}

	@Override
	public void setChoices(List<ChoiceDto> choices) {
		this.choices = choices;
	}

}

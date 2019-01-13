package com.nytcoder.originator.mcq.model.impl;

import com.nytcoder.originator.mcq.model.ChoiceDto;

public class ChoiceDtoImpl implements ChoiceDto{
	private Long choiceId;
	private String choice;
	private Boolean isImage;
	
	@Override
	public Long getChoiceId() {
		return choiceId;
	}
	
	@Override
	public void setChoiceId(Long choiceId) {
		this.choiceId = choiceId;
	}
	@Override
	public String getChoice() {
		return choice;
	}

	@Override
	public void setChoice(String choice) {
		this.choice = choice;
	}

	@Override
	public Boolean getIsImage() {
		return isImage;
	}

	@Override
	public void setIsImage(Boolean isImage) {
		this.isImage = isImage;
	}

	

}

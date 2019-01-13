package com.nytcoder.originator.mcq.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = ChoiceDto.class)
public interface ChoiceDto {

	public Long getChoiceId();
	
	public void setChoiceId(Long choiceId);
	
	public String getChoice();

	public void setChoice(String choice);

	public Boolean getIsImage();

	public void setIsImage(Boolean isImage);
	
}

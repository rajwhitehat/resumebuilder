package com.nytcoder.originator.mcq.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "que_choices")
public class QueChoicesEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "choiceId")
	private Long choiceId;
	@Column(name = "choice")
	private String choice;
	@Column(name = "isImage")
	private Boolean isImage;
	@Column(name = "questionId")
	private Long questionId;
	
	public Long getChoiceId() {
		return choiceId;
	}
	public void setChoiceId(Long choiceId) {
		this.choiceId = choiceId;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public Boolean getIsImage() {
		return isImage;
	}
	public void setIsImage(Boolean isImage) {
		this.isImage = isImage;
	}
	public Long getQuestionId() {
		return questionId;
	}
	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}
}

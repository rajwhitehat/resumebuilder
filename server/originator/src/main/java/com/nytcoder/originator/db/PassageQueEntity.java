package com.nytcoder.originator.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "passage_que")
public class PassageQueEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "passageId")
	private Long passageId;
	@Column(name = "passageName")
	private String passageName;
	public Long getPassageId() {
		return passageId;
	}
	public void setPassageId(Long passageId) {
		this.passageId = passageId;
	}
	public String getPassageName() {
		return passageName;
	}
	public void setPassageName(String passageName) {
		this.passageName = passageName;
	}
	
}

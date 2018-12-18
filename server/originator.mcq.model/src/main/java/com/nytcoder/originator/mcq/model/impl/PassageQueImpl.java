package com.nytcoder.originator.mcq.model.impl;

import com.nytcoder.originator.mcq.model.PassageQue;

public class PassageQueImpl implements PassageQue{
	private Long passageId;
	private String passageName;
	@Override
	public Long getPassageId() {
		return passageId;
	}
	@Override
	public void setPassageId(Long passageId) {
		this.passageId = passageId;
	}
	@Override
	public String getPassageName() {
		return passageName;
	}
	@Override
	public void setPassageName(String passageName) {
		this.passageName = passageName;
	}
	
	
}

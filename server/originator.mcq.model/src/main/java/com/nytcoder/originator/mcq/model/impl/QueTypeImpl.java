package com.nytcoder.originator.mcq.model.impl;

import com.nytcoder.originator.mcq.model.QueType;

public class QueTypeImpl implements QueType{
	
	private Long typeId;
	private String typeName;
	@Override				
	public Long getTypeId() {
		return typeId;
	}
	@Override
	public void setTypeId(Long typeId) {
		this.typeId = typeId;
	}
	@Override
	public String getTypeName() {
		return typeName;
	}
	@Override
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}

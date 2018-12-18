package com.nytcoder.originator.mcq.model.impl;

import com.nytcoder.originator.mcq.model.Subject;

public class SubjectImpl implements Subject {
	private Long subjectId;
	private String subjectName;
	@Override
	public Long getSubjectId() {
		return subjectId;
	}
	@Override
	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}
	@Override
	public String getSubjectName() {
		return subjectName;
	}
	@Override
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	
	
}

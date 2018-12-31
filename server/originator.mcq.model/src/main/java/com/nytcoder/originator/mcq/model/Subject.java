package com.nytcoder.originator.mcq.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.nytcoder.originator.mcq.model.impl.SubjectImpl;

@JsonDeserialize(as = SubjectImpl.class)
public interface Subject {

	public Long getSubjectId();

	public void setSubjectId(Long subjectId);

	public void setSubjectName(String subjectName);

	public String getSubjectName();

}

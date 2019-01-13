package com.nytcoder.originator.mcq.service;

import java.util.List;

import com.nytcoder.originator.mcq.model.QueChoiceDto;
import com.nytcoder.originator.mcq.model.Subject;

public interface McqService {

	public List<Subject> getAllSubject() throws Exception;

	public List<QueChoiceDto> getQuestion(Long subjectId) throws Exception;

}

package com.nytcoder.originator.mcq.service.impl;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nytcoder.originator.mcq.db.SubjectEntity;
import com.nytcoder.originator.mcq.mapper.McqMapper;
import com.nytcoder.originator.mcq.model.Subject;
import com.nytcoder.originator.mcq.repositrory.QuestionsJpaRepository;
import com.nytcoder.originator.mcq.repositrory.SubjectJpaRepository;
import com.nytcoder.originator.mcq.service.McqService;

@Service
public class McqServiceImpl implements McqService{

	@Autowired
	QuestionsJpaRepository questionsJpaRepositroy;
	
	@Autowired
	SubjectJpaRepository subjectJpaRepository;
	@Autowired
	McqMapper mcqMapper;
	
	@Override
	public List<Subject> getAllSubject() {
		List<SubjectEntity> subjectEntities = subjectJpaRepository.getAllSubject();
		List<Subject> subjectList = new ArrayList<Subject>();
		subjectList = mcqMapper.convertSubjectEntityToDTO(subjectEntities);
		return subjectList;
	}
	
	
}

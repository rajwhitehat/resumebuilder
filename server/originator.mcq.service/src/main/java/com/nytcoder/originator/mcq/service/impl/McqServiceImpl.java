package com.nytcoder.originator.mcq.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.originator.common.OriginatorConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.nytcoder.originator.mcq.db.QuestionsEntity;
import com.nytcoder.originator.mcq.db.SubjectEntity;
import com.nytcoder.originator.mcq.mapper.McqMapper;
import com.nytcoder.originator.mcq.model.Questions;
import com.nytcoder.originator.mcq.model.Subject;
import com.nytcoder.originator.mcq.repositrory.QuestionJpaRepository;
import com.nytcoder.originator.mcq.repositrory.SubjectJpaRepository;
import com.nytcoder.originator.mcq.service.McqService;

@Service
public class McqServiceImpl implements McqService{

	@Autowired
	SubjectJpaRepository subjectJpaRepository;
	
	@Autowired
	QuestionJpaRepository questionJpaRepository;
	
	@Autowired
	McqMapper mcqMapper;
	
	
	@Override
	public List<Subject> getAllSubject() throws Exception{
		List<SubjectEntity> subjectEntities = subjectJpaRepository.getAllSubject();
		if(ObjectUtils.isEmpty(subjectEntities)) {
			throw new Exception(OriginatorConstant.No_Subject);
		}
		List<Subject> subjectList = new ArrayList<Subject>();
		subjectList = mcqMapper.convertSubjectEntityToDTO(subjectEntities);
		return subjectList;
	}
	@Override
	public List<Questions> getQuestion(Long subjectId) throws Exception{
		Pageable pageRequest = new PageRequest(0,5);
		List<QuestionsEntity> questionEntities = questionJpaRepository.getQuestion(subjectId, pageRequest);
		if(ObjectUtils.isEmpty(questionEntities)) {
			throw new Exception(OriginatorConstant.No_Question);
		}
		List<Questions> questions = new ArrayList<Questions>();
		questions = mcqMapper.convertQuestionEntityToDTO(questionEntities);
		return questions;
	}
	
	
}

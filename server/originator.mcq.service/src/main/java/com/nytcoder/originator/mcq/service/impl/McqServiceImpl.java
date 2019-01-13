package com.nytcoder.originator.mcq.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.originator.common.OriginatorConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.nytcoder.originator.mcq.db.ChoicesEntity;
import com.nytcoder.originator.mcq.db.QuestionsEntity;
import com.nytcoder.originator.mcq.db.SubjectEntity;
import com.nytcoder.originator.mcq.mapper.McqMapper;
import com.nytcoder.originator.mcq.model.ChoiceDto;
import com.nytcoder.originator.mcq.model.QueChoiceDto;
import com.nytcoder.originator.mcq.model.Questions;
import com.nytcoder.originator.mcq.model.Subject;
import com.nytcoder.originator.mcq.model.impl.ChoiceDtoImpl;
import com.nytcoder.originator.mcq.model.impl.QueChoiceDtoImpl;
import com.nytcoder.originator.mcq.repositrory.ChoicesJpaRepository;
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
	ChoicesJpaRepository choicesJpaRepository;
	
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
	public List<QueChoiceDto> getQuestion(Long subjectId) throws Exception{
		Pageable pageRequest = new PageRequest(0,5);
		List<QuestionsEntity> questionEntities = questionJpaRepository.getQuestion(subjectId, pageRequest);
		if(ObjectUtils.isEmpty(questionEntities)) {
			throw new Exception(OriginatorConstant.No_Question);
		}
		Set<Long> qIds = questionEntities.stream().map(QuestionsEntity::getQuestionId).collect(Collectors.toSet());
		List<ChoicesEntity> choiceEntities = choicesJpaRepository.getChoices(qIds);
		List<QueChoiceDto> queChoiceDtos = new ArrayList<QueChoiceDto>();
		List<ChoiceDto> choiceDtos = null;
		QueChoiceDto queChoiceDto = null;
		ChoiceDto choiceDto = null;
		for(QuestionsEntity queEntity : questionEntities) {
			queChoiceDto = new QueChoiceDtoImpl();
			queChoiceDto.setQuestionId(queEntity.getQuestionId());
			queChoiceDto.setQuestion(queEntity.getQuestion());
			queChoiceDto.setIsImage(queEntity.getIsImage());
			queChoiceDto.setTypeId(queEntity.getTypeId());
			if(queEntity.getTypeId().equals(1l)) {
				choiceDtos = new ArrayList<ChoiceDto>();
				List<ChoicesEntity> chEntity = choiceEntities.stream().map(e -> e).
						filter(e -> e.getQuestionId().equals(queEntity.getQuestionId())).collect(Collectors.toList());
				for(ChoicesEntity choiceEntity : chEntity) {
					choiceDto = new ChoiceDtoImpl();
					choiceDto.setChoiceId(choiceEntity.getChoiceId());
					choiceDto.setChoice(choiceEntity.getChoice());
					choiceDto.setIsImage(choiceEntity.getIsImage());
					choiceDtos.add(choiceDto);
				}
				queChoiceDto.setChoices(choiceDtos);
			}
			queChoiceDtos.add(queChoiceDto);
		}
		
		/*List<Questions> questions = new ArrayList<Questions>();
		questions = mcqMapper.convertQuestionEntityToDTO(questionEntities);*/
		return queChoiceDtos;
	}
	
	
}

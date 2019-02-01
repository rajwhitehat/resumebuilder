package com.nytcoder.originator.mcq.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.tomcat.util.codec.binary.Base64;
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
	private static String baseDir = "src\\main\\resources\\images\\";
	private static String questionDir = "question\\";
	private static String answerDir = "answer\\";
	private static String UTF_FORMAT = "UTF-8";
	private static String IMAGE_TYPE = "data:image/png;base64,";
	
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
			queChoiceDto.setIsImage(queEntity.getIsImage());
			String question= null;
			question = getQuestion(queEntity);
			queChoiceDto.setQuestion(question);
			queChoiceDto.setTypeId(queEntity.getTypeId());
			if(queEntity.getTypeId().equals(1l)) {
				choiceDtos = new ArrayList<ChoiceDto>();
				List<ChoicesEntity> chEntity = choiceEntities.stream().map(e -> e).
						filter(e -> e.getQuestionId().equals(queEntity.getQuestionId())).collect(Collectors.toList());
				for(ChoicesEntity choiceEntity : chEntity) {
					choiceDto = new ChoiceDtoImpl();
					choiceDto.setChoiceId(choiceEntity.getChoiceId());
					choiceDto.setIsImage(choiceEntity.getIsImage());
					String choice= null;
					choice = getChoice(choiceEntity);
					choiceDto.setChoice(choice);
					choiceDtos.add(choiceDto);
				}
				queChoiceDto.setChoices(choiceDtos);
			}
			queChoiceDtos.add(queChoiceDto);
		}
		return queChoiceDtos;
	}
	
	private String getChoice(ChoicesEntity choiceEntity) throws Exception {
		String choice = choiceEntity.getChoice();
		if(choiceEntity.getIsImage()) {
			File file = new File(baseDir + answerDir + choice);
			choice = IMAGE_TYPE + getImageInBase64(file);
		}
		return choice;
	}
	private String getQuestion(QuestionsEntity queEntity) throws Exception {
		String question = queEntity.getQuestion();
		if(queEntity.getIsImage()) {
			File file = new File(baseDir + questionDir + question);
			question = IMAGE_TYPE + getImageInBase64(file);
		}
		return question;
	}
	@SuppressWarnings("resource")
	private String getImageInBase64(File file) throws Exception {
		FileInputStream fileInputStreamReader = new FileInputStream(file);
        byte[] bytes = new byte[(int)file.length()];
        fileInputStreamReader.read(bytes);
        String imageInBase64 = new String(Base64.encodeBase64(bytes), UTF_FORMAT);
        return imageInBase64; 
	}
	
	
}

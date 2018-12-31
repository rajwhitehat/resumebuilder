package com.nytcoder.originator.mcq.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.nytcoder.originator.mcq.db.SubjectEntity;
import com.nytcoder.originator.mcq.model.Subject;
import com.nytcoder.originator.mcq.model.impl.SubjectImpl;

@Component
public class McqMapper {
	
	ModelMapper modelMapper = new ModelMapper();

	public Subject convertSubjectEntityToDTO(SubjectEntity subjectEntity) {
		Subject subject = modelMapper.map(subjectEntity, SubjectImpl.class);
		return subject;
	}

	public List<Subject> convertSubjectEntityToDTO(List<SubjectEntity> subjectEntities) {
		List<Subject> subject = subjectEntities.stream().map
				(entity -> convertSubjectEntityToDTO(entity)).
				collect(Collectors.toList());
		return subject;
	}

}
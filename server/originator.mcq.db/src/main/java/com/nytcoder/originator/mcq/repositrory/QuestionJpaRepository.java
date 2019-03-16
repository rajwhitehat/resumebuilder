package com.nytcoder.originator.mcq.repositrory;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nytcoder.originator.mcq.db.QuestionsEntity;

public interface QuestionJpaRepository extends JpaRepository<QuestionsEntity, Long> {
	
	@Query(value = "select q from QuestionsEntity q where q.subjectId =?1 Order by RAND()")
	public List<QuestionsEntity> getQuestion(Long subjectId, Pageable pageRequest);

}

package com.nytcoder.originator.mcq.repositrory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nytcoder.originator.mcq.db.QuestionsEntity;

public interface QuestionsJpaRepository extends JpaRepository<QuestionsEntity, Long> {
	
	@Query(value = "select q from QuestionsEntity q where subject =?1")
	public List<QuestionsEntity> getQuestions(Long subjectId);

}

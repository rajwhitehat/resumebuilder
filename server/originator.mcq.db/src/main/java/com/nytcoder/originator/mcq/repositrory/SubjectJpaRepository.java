package com.nytcoder.originator.mcq.repositrory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nytcoder.originator.mcq.db.SubjectEntity;

public interface SubjectJpaRepository extends JpaRepository<SubjectEntity, Long> {
	
	@Query(value = "select s from SubjectEntity s")
	public List<SubjectEntity> getAllSubject();
}

package com.nytcoder.originator.mcq.repositrory;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nytcoder.originator.mcq.db.ChoicesEntity;

public interface ChoicesJpaRepository extends JpaRepository<ChoicesEntity, Long>{

	@Query(value = "select qc from ChoicesEntity qc where questionId in ?1")
	public List<ChoicesEntity> getChoices(Set<Long> qIds);
}

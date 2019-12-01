package com.spring.getready.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.getready.model.SubmissionDetail;
import com.spring.getready.model.UserDetail;

@Repository
public interface SubmissionDetailRepository extends JpaRepository<SubmissionDetail, Integer> {

	List<SubmissionDetail> findByUserDetailEquals(UserDetail userDetail);
	
}

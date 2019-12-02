package com.spring.getready.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.getready.model.AcademicDetail;
import com.spring.getready.model.UserDetail;

@Repository
public interface AcademicDetailRepository extends JpaRepository<AcademicDetail, Integer> {

	List<AcademicDetail> findByUserDetailEquals(UserDetail userDetail);
	
}

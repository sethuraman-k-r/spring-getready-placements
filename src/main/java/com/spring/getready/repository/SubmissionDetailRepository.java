package com.spring.getready.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.getready.model.SubmissionDetail;

@Repository
public interface SubmissionDetailRepository extends JpaRepository<SubmissionDetail, Integer> {

}

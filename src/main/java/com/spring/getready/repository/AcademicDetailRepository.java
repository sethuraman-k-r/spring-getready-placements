package com.spring.getready.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.getready.model.AcademicDetail;

@Repository
public interface AcademicDetailRepository extends JpaRepository<AcademicDetail, Integer> {

}

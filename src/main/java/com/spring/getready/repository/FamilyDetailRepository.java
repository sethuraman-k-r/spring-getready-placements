package com.spring.getready.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.getready.model.FamilyDetail;

@Repository
public interface FamilyDetailRepository extends JpaRepository<FamilyDetail, Integer> {

}

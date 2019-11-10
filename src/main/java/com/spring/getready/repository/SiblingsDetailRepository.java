package com.spring.getready.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.getready.model.SiblingsDetail;

@Repository
public interface SiblingsDetailRepository extends JpaRepository<SiblingsDetail, Integer> {

}

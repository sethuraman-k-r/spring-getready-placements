package com.spring.getready.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.getready.model.FamilyDetail;
import com.spring.getready.model.SiblingsDetail;

@Repository
public interface SiblingsDetailRepository extends JpaRepository<SiblingsDetail, Integer> {

	List<SiblingsDetail> findByFamilyDetailEquals(FamilyDetail familyDetail);
	
}

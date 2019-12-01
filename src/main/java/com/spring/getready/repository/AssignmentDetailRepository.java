package com.spring.getready.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.getready.model.AssignmentDetail;

@Repository
public interface AssignmentDetailRepository extends JpaRepository<AssignmentDetail, Integer> {

	List<AssignmentDetail> findByIsDeletedFalse();

	@Query("SELECT a FROM AssignmentDetail a WHERE a NOT IN (:submissions)")
	List<AssignmentDetail> findNonSubmittedAssignments(@Param("submissions") List<AssignmentDetail> assignmentDetails);

}

package com.spring.getready.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.getready.model.CourseList;

@Repository
public interface CourseListRepository extends JpaRepository<CourseList, Integer> {

}

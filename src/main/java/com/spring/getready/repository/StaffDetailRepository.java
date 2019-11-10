package com.spring.getready.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.getready.model.StaffDetail;

@Repository
public interface StaffDetailRepository extends JpaRepository<StaffDetail, Integer> {

}

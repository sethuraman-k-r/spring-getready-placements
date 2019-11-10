package com.spring.getready.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.getready.model.ProfileInfo;

@Repository
public interface ProfileInfoRepository extends JpaRepository<ProfileInfo, Integer> {

}

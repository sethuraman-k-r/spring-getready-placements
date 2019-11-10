package com.spring.getready.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.getready.model.UserGroup;

@Repository
public interface UserGroupRepository extends JpaRepository<UserGroup, Integer> {

}

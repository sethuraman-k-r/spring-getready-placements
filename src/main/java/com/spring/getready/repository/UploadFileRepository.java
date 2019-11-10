package com.spring.getready.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.getready.model.UploadFile;

@Repository
public interface UploadFileRepository extends JpaRepository<UploadFile, Integer> {

}

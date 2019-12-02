package com.spring.getready.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.getready.repository.AcademicDetailRepository;
import com.spring.getready.repository.UserDetailRepository;
import com.spring.getready.template.model.AcademicTemplate;
import com.spring.getready.model.AcademicDetail;
import com.spring.getready.model.UserDetail;

@Service
public class AcademicService {

	@Autowired
	private AcademicDetailRepository academicDetailRepository;

	@Autowired
	private UserDetailRepository userDetailRepository;

	public List<AcademicDetail> getAcademicDetails(String uuid) {
		UserDetail userDetail = userDetailRepository.findByUserUuidEquals(uuid);
		if (userDetail != null) {
			return academicDetailRepository.findByUserDetailEquals(userDetail);
		}
		return new ArrayList<AcademicDetail>();
	}

	public boolean addAcademicDetails(AcademicTemplate academicTemplate, String uuid) {
		boolean result = false;
		UserDetail userDetail = userDetailRepository.findByUserUuidEquals(uuid);
		if (userDetail != null) {
			AcademicDetail academicDetail = new AcademicDetail();
			academicDetail.setAcademicName(academicTemplate.getName());
			academicDetail.setDescription(academicTemplate.getDescription());
			academicDetail.setStartYear(academicTemplate.getStart());
			academicDetail.setEndYear(academicTemplate.getEnd());
			academicDetail.setUserDetail(userDetail);
			result = academicDetailRepository.save(academicDetail) != null;
		}
		return result;
	}

	public boolean deleteAcademicDetails(Integer academicId, String uuid) {
		boolean result = false;
		UserDetail userDetail = userDetailRepository.findByUserUuidEquals(uuid);
		if (userDetail != null) {
			Optional<AcademicDetail> academicDetail = academicDetailRepository.findById(academicId);
			if (academicDetail.isPresent()) {
				academicDetailRepository.delete(academicDetail.get());
				result = true;
			}
		}
		return result;
	}

}

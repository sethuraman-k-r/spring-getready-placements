package com.spring.getready.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.getready.model.FamilyDetail;
import com.spring.getready.model.SiblingsDetail;
import com.spring.getready.model.UserDetail;
import com.spring.getready.repository.FamilyDetailRepository;
import com.spring.getready.repository.SiblingsDetailRepository;
import com.spring.getready.repository.UserDetailRepository;
import com.spring.getready.template.model.ParentsTemplate;

@Service
public class RelationService {

	@Autowired
	public UserDetailRepository userDetailRepository;

	@Autowired
	public SiblingsDetailRepository siblingsDetailRepository;

	@Autowired
	public FamilyDetailRepository familyDetailRepository;

	public Map<String, Object> getFamilyDetails(String uuid) {
		Map<String, Object> familyDetails = new HashMap<String, Object>();
		UserDetail userDetail = userDetailRepository.findByUserUuidEquals(uuid);
		if (userDetail != null) {
			FamilyDetail familyDetail = userDetail.getFamilyDetail();
			familyDetails.put("parents", familyDetail);
			familyDetails.put("siblings", getSiblingsDetails(familyDetail));
		} else {
			familyDetails.put("parents", null);
			familyDetails.put("siblings", null);
		}
		return familyDetails;
	}

	public List<SiblingsDetail> getSiblingsDetails(FamilyDetail familyDetail) {
		List<SiblingsDetail> siblings = null;
		if (familyDetail != null) {
			siblings = siblingsDetailRepository.findByFamilyDetailEquals(familyDetail);
		} else {
			siblings = new ArrayList<SiblingsDetail>();
		}
		return siblings;
	}

	public boolean addFamilyDetails(ParentsTemplate parent, String uuid) {
		boolean result = false;
		UserDetail userDetail = userDetailRepository.findByUserUuidEquals(uuid);
		if (userDetail != null) {
			FamilyDetail familyDetail = new FamilyDetail();
			familyDetail.setFatherName(parent.getFatherName());
			familyDetail.setFatherOccupation(parent.getFatherOccupation());
			familyDetail.setMotherName(parent.getMotherName());
			familyDetail.setMotherOccupation(parent.getMotherOccupation());
			result = familyDetailRepository.save(familyDetail) != null;
			userDetail.setFamilyDetail(familyDetail);
			userDetailRepository.save(userDetail);
		}
		return result;
	}

}

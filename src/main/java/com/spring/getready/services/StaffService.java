package com.spring.getready.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.getready.model.StaffDetail;
import com.spring.getready.repository.StaffDetailRepository;

@Service
public class StaffService {

	@Autowired
	private StaffDetailRepository staffDetailRepository;

	public boolean addNewStaff(String name, String field, String technology) {
		boolean result = false;
		StaffDetail staffDetail = new StaffDetail();
		staffDetail.setStaffName(name);
		staffDetail.setField(field);
		staffDetail.setTechnologyKnown(technology);
		StaffDetail updatedStaffDetail = staffDetailRepository.save(staffDetail);
		result = (updatedStaffDetail != null);
		return result;
	}

	public boolean editStaff(int id, String name, String field, String technology) {
		boolean result = false;
		Optional<StaffDetail> staff = staffDetailRepository.findById(id);
		if (staff.isPresent()) {
			StaffDetail staffDetail = staff.get();
			staffDetail.setStaffName(name);
			staffDetail.setField(field);
			staffDetail.setTechnologyKnown(technology);
			StaffDetail updatedStaffDetail = staffDetailRepository.save(staffDetail);
			result = (updatedStaffDetail != null);
		}
		return result;
	}

}

package com.spring.getready.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.getready.model.CourseList;
import com.spring.getready.model.StaffDetail;
import com.spring.getready.repository.CourseListRepository;
import com.spring.getready.repository.StaffDetailRepository;

import org.springframework.stereotype.Service;

@Service
public class CourseService {

	@Autowired
	private CourseListRepository courseListRepository;

	@Autowired
	private StaffDetailRepository staffDetailRepository;

	public boolean addNewCourse(String name, String field, Integer staffid, List<Integer> supportStaff) {
		boolean result = false;
		StaffDetail primaryStaff = null;
		if (staffid != null) {
			Optional<StaffDetail> staff = staffDetailRepository.findById(staffid);
			primaryStaff = staff.isPresent() ? staff.get() : null;

			CourseList course = new CourseList();
			course.setCourseField(field);
			course.setCourseName(name);
			course.setStaffDetail(primaryStaff);

			if (supportStaff != null) {
				for (int i = 0; i < supportStaff.size(); i++) {
					Optional<StaffDetail> support = staffDetailRepository.findById(supportStaff.get(i));
					if (support.isPresent()) {
						StaffDetail supportStaffWithCourse = support.get();
						supportStaffWithCourse.getCourseLists2().add(course);
					}
				}
			}

			result = courseListRepository.save(course) != null;
		}
		return result;
	}

}

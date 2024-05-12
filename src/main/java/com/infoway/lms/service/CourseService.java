package com.infoway.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infoway.lms.dao.AssignedCourseRepository;
import com.infoway.lms.model.AssignedCourse;

import java.util.List;

@Service
public class CourseService {

	@Autowired
	private AssignedCourseRepository assignedCourseRepository;

	public List<AssignedCourse> getAssignedCourses(String userId) {
		return assignedCourseRepository.findByUserId(userId);
	}
}

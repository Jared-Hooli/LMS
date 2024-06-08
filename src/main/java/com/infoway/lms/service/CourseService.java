package com.infoway.lms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infoway.lms.dao.AssignedCourseRepository;
import com.infoway.lms.dto.response.GetAssignedCoursesResponse;
import com.infoway.lms.model.AssignedCourse;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

	@Autowired
	private AssignedCourseRepository assignedCourseRepository;

	public List<GetAssignedCoursesResponse> getAssignedCourses(String userId) {
	    List<AssignedCourse> courses = assignedCourseRepository.findByUserId(userId);
	    return courses.stream().map(course -> new GetAssignedCoursesResponse(
	            course.getUserId(),
	            course.getCourseId(),
	            course.getCapability(),
	            course.getTargetDateCompletion(),
	            course.getTrainingStatus(),
	            course.getScore(),
	            course.getUser().getUserName(),  // Assuming User has getName()
	            course.getCourse().getCourseName()  // Assuming Course has getName()
	        )).collect(Collectors.toList());
	}
}

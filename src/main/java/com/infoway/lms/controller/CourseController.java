package com.infoway.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.infoway.lms.representation.response.GetAssignedCoursesResponse;
import com.infoway.lms.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<GetAssignedCoursesResponse>> getAssignedCourses(@PathVariable String userId) {
        List<GetAssignedCoursesResponse> courses = courseService.getAssignedCourses(userId);
        return ResponseEntity.ok(courses);
    }
}

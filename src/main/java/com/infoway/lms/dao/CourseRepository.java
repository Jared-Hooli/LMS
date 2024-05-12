package com.infoway.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infoway.lms.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
}


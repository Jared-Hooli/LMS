package com.infoway.lms.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.infoway.lms.model.AssignedCourse;
import com.infoway.lms.model.AssignedCourseId;

import java.util.List;

@Repository
public interface AssignedCourseRepository extends JpaRepository<AssignedCourse, AssignedCourseId> {
    List<AssignedCourse> findByUserId(String userId);
}


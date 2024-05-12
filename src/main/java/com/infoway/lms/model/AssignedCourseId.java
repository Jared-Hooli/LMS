package com.infoway.lms.model;

import java.io.Serializable;
import java.util.Objects;

public class AssignedCourseId implements Serializable {
	private String userId;   // Maps to User_id in the Assigned_courses table
    private String courseId; // Maps to Course_id in the Assigned_courses table

    // Default constructor
    public AssignedCourseId() {}

    // Constructor with fields
    public AssignedCourseId(String userId, String courseId) {
        this.userId = userId;
        this.courseId = courseId;
    }

    // Getters, setters, equals, and hashCode
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AssignedCourseId that = (AssignedCourseId) o;
        return Objects.equals(userId, that.userId) &&
               Objects.equals(courseId, that.courseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, courseId);
    }
}

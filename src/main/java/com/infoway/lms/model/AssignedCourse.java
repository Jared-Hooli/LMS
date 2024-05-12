package com.infoway.lms.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Assigned_courses")
@IdClass(AssignedCourseId.class) // Make sure to link the IdClass
public class AssignedCourse {
    @Id
    @Column(name = "User_id")
    private String userId; // Matches a field in AssignedCourseId

    @Id
    @Column(name = "Course_id")
    private String courseId; // Matches a field in AssignedCourseId

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_id", referencedColumnName = "User_id", insertable = false, updatable = false)
    private User user; // Link to the User entity

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Course_id", referencedColumnName = "Course_id", insertable = false, updatable = false)
    private Course course; // Link to the Course entity

    @Column(name = "Capability")
    private String capability;

    @Column(name = "Target_date_completion")
    private Date targetDateCompletion;

    @Column(name = "Training_status")
    private String trainingStatus;

    @Column(name = "Score")
    private Integer score;

    // Constructors, getters, and setters

    public AssignedCourse() {
    }

    public AssignedCourse(String userId, String courseId, String capability, Date targetDateCompletion, String trainingStatus, Integer score) {
        this.userId = userId;
        this.courseId = courseId;
        this.capability = capability;
        this.targetDateCompletion = targetDateCompletion;
        this.trainingStatus = trainingStatus;
        this.score = score;
    }

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getCapability() {
        return capability;
    }

    public void setCapability(String capability) {
        this.capability = capability;
    }

    public Date getTargetDateCompletion() {
        return targetDateCompletion;
    }

    public void setTargetDateCompletion(Date targetDateCompletion) {
        this.targetDateCompletion = targetDateCompletion;
    }

    public String getTrainingStatus() {
        return trainingStatus;
    }

    public void setTrainingStatus(String trainingStatus) {
        this.trainingStatus = trainingStatus;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}

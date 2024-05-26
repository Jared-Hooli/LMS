package com.infoway.lms.representation.response;

import java.util.Date;

public class GetAssignedCoursesResponse {
    private String userId;
    private String courseId;
    private String capability;
    private Date targetDateCompletion;
    private String trainingStatus;
    private Integer score;
    private String userName;  // Optional: Additional fields from User
    private String courseName; // Optional: Additional fields from Course

    // Constructors, Getters, and Setters
    public GetAssignedCoursesResponse(String userId, String courseId, String capability, Date targetDateCompletion, String trainingStatus, Integer score, String userName, String courseName) {
        this.userId = userId;
        this.courseId = courseId;
        this.capability = capability;
        this.targetDateCompletion = targetDateCompletion;
        this.trainingStatus = trainingStatus;
        this.score = score;
        this.userName = userName;
        this.courseName = courseName;
    }

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the courseId
	 */
	public String getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}

	/**
	 * @return the capability
	 */
	public String getCapability() {
		return capability;
	}

	/**
	 * @param capability the capability to set
	 */
	public void setCapability(String capability) {
		this.capability = capability;
	}

	/**
	 * @return the targetDateCompletion
	 */
	public Date getTargetDateCompletion() {
		return targetDateCompletion;
	}

	/**
	 * @param targetDateCompletion the targetDateCompletion to set
	 */
	public void setTargetDateCompletion(Date targetDateCompletion) {
		this.targetDateCompletion = targetDateCompletion;
	}

	/**
	 * @return the trainingStatus
	 */
	public String getTrainingStatus() {
		return trainingStatus;
	}

	/**
	 * @param trainingStatus the trainingStatus to set
	 */
	public void setTrainingStatus(String trainingStatus) {
		this.trainingStatus = trainingStatus;
	}

	/**
	 * @return the score
	 */
	public Integer getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(Integer score) {
		this.score = score;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}

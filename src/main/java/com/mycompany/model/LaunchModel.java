package com.mycompany.model;

import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.HashMap;

/**
 * Created by IntelliJ IDEA.
 * User: jwiseman
 * Date: Jul 19, 2017
 * Time: 10:04:01 PM
 * To change this template use File | Settings | File Templates.
 */
public class LaunchModel {
    private String ltiParms;
    private String returnUrl;
    private String action;
    private String courseId;
    private String userId;
    private String courseName;
    private String courseDescription;
    private String studentId;

    public ModelAndView getLaunchView () {
        Map<String, String> launchValues = new HashMap<String, String>(); 
        launchValues.put ("ltiParms", getLtiParms());
        launchValues.put ("returnUrl", getReturnUrl());
        launchValues.put ("courseId", getCourseId());
        launchValues.put ("userId", getUserId());
        launchValues.put ("studentId", getStudentId());
        launchValues.put ("action", getAction());
        launchValues.put ("courseName", getCourseName());
        launchValues.put ("courseDescription", getCourseDescription());
        return new  ModelAndView ("launch", launchValues);
    }

    public String getLtiParms() {
        return ltiParms;
    }

    public void setLtiParms(String ltiParms) {
        this.ltiParms = ltiParms;
    }

    public String getReturnUrl() {
        return returnUrl;
    }

    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }
}

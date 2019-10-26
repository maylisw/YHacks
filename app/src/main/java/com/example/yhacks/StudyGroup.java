package com.example.yhacks;

import android.util.Log;

import java.util.ArrayList;

public class StudyGroup {

    private static final String TAG= "StudyGroup";
    private int id;
    private String name;
    private String course;
    private String subject;
    private String schedule;
    private String[] time;
    private String[] date;
    private String university;
    private String location;
    private int    userCount;
    private int    ownerId;

    public StudyGroup(String name, String course, String subject, String schedule, String university, String location, int userCount, int ownerId, int id) {
        this.name       = name;
        this.course     = course;
        this.subject    = subject;
        this.schedule   = schedule;
        this.university = university;
        this.location   = location;
        this.userCount  = userCount;
        this.ownerId    = ownerId;
        this.id         = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void setTimeDate() {
        time = new String[2];
        date = new String[1];
        time[0] = "3";
        time[1] = "4";
        date[0] = "M";
//        String[] timeDate = schedule.split(", ");
//        time = new String[timeDate.length/2];
//        date = new String[timeDate.length/2];
//        for(int i = 0; i<timeDate.length; i++) {
//            String[] m = timeDate[i].split(" ");
//            date[i] = m[0];
//            time[i] = m[1];
//        }
    }

    public String[] getTime() { return time; }

    public String[] getDate() { return date; }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Group {" +
                "name='" + name + "'" +
                "course='" + course + "'" +
                "subject='" + subject + "'" +
                "schedule='" + schedule + "'" +
                "university='" + university + "'" +
                "location='" + location + "'" +
                "user_count='" + userCount + "'" +
                "owner_id='" + ownerId + "'" +
                "id=" + id + "'" +
                "}";
    }
}

package com.example.yhacks;

public class StudyGroup {

    private int id;
    private String name;
    private String course;
    private String subject;
    private String schedule;
    private String university;
    private int    ownerId;

    public StudyGroup(String name, String course, String subject, String schedule, String university, int ownerId, int id) {
        this.name       = name;
        this.course     = course;
        this.subject    = subject;
        this.schedule   = schedule;
        this.university = university;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Group {" +
                "name='" + name + "'" +
                "course='" + course + "'" +
                "subject='" + subject + "'" +
                "schedule='" + schedule + "'" +
                "university='" + university + "'" +
                "owner_id='" + ownerId + "'" +
                "id=" + id + "'" +
                "}";
    }
}

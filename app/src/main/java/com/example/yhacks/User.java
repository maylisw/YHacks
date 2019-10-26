package com.example.yhacks;

public class User {

    private String name;
    private String university;
    private String classes;
    private String goodAt;
    private String needsHelpWith;
    private String profilePicture;
    private String email;
    private String authToken;

    public User(String name, String university, String classes, String goodAt, String needsHelpWith, String profilePicture, String email, String authToken) {
        this.name           = name;
        this.university     = university;
        this.classes        = classes;
        this.goodAt         = goodAt;
        this.needsHelpWith  = needsHelpWith;
        this.profilePicture = profilePicture;
        this.email          = email;
        this.authToken      = authToken;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public String getGoodAt() {
        return goodAt;
    }

    public void setGoodAt(String goodAt) {
        this.goodAt = goodAt;
    }

    public String getNeedsHelpWith() {
        return needsHelpWith;
    }

    public void setNeedsHelpWith(String needsHelpWith) {
        this.needsHelpWith = needsHelpWith;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
}

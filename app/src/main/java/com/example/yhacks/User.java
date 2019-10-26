package com.example.yhacks;

public class User {

    private int id;
    private String name;
    private String university;
    private String classes;
    private String goodAt;
    private String needsHelpWith;
    private String profilePicture;
    private String email;
    private String authToken;
    private String password;
    private String passwordConfirmation;

    public User(String name, String university, String classes, String goodAt, String needsHelpWith, String profilePicture, String email, String authToken, int id) {
        this.id                   = id;
        this.name                 = name;
        this.university           = university;
        this.classes              = classes;
        this.goodAt               = goodAt;
        this.needsHelpWith        = needsHelpWith;
        this.profilePicture       = profilePicture;
        this.email                = email;
        this.authToken            = authToken;
        this.password             = password;
        this.passwordConfirmation = passwordConfirmation;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString() {
        return "User {" +
                "id='" + id + "'" +
                "name='" + name + "'" +
                "university='" + university + "'" +
                "classes='" + classes + "'" +
                "good_at='" + goodAt + "'" +
                "needs_help_with='" + needsHelpWith + "'" +
                "profile_picture='" + profilePicture + "'" +
                "email='" + email + "'" +
                "good_at='" + goodAt + "'" +
                "password='" + password + "'" +
                "password_confirmation='" + passwordConfirmation + "'" +
                "}";
    }
}



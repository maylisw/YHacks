package com.example.yhacks;

public class University {

    private int id;
    private String name;
    private String city;

    public University(String name, String city, int id) {
        this.name = name;
        this.city = city;
        this.id   = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User {" +
                "id='" + id + "'" +
                "name='" + name + "'" +
                "city='" + city + "'" +
                "}";
     }
}

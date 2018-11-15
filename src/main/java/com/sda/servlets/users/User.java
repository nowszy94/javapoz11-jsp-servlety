package com.sda.servlets.users;

public class User {
    private String firstName;
    private String lastName;
    private Integer age;
    private UserGender gender;

    public User(String firstName, String lastName, Integer age, UserGender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public UserGender getGender() {
        return gender;
    }
}

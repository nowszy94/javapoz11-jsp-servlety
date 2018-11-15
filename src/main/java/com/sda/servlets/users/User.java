package com.sda.servlets.users;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer age;
    private UserGender gender;

    public User(String firstName, String lastName, Integer age, UserGender gender) {
        this(null, firstName, lastName, age, gender);
    }

    @JsonCreator
    public User(
            @JsonProperty("id") Integer id,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName,
            @JsonProperty("age") Integer age,
            @JsonProperty("gender") UserGender gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
    }

    public Integer getId() {
        return id;
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

    public void setId(Integer id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setGender(UserGender gender) {
        this.gender = gender;
    }
}

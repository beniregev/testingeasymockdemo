package com.beniregev.model;

import com.beniregev.enums.UserType;

import java.time.ZonedDateTime;

public class User {
    private Integer id; //  Can be assigned from constructor
    private String name;
    private String username;
    private UserType userType;
    private String password;
    private Schedule schedule;

    public User() {
        //  Default
    }

    public User(Integer id, String name, UserType userType) {
        this(id, name, userType, name + "123");
    }

    public User(Integer id, String name, UserType userType, String username) {
        this.setId(id);
        this.setName(name);
        this.setUserType(userType);
        this.setUsername(username);
        this.setPassword("Password1");
    }

    public Integer getId() {
        return id;
    }

    private void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}

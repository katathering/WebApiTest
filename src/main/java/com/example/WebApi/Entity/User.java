package com.example.WebApi.Entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;


public class User {

    @Id
    private ObjectId _id;

    private String firstname;
    private String lastname;
    private String userRole;
    private String password;
    private String email;

    public User(ObjectId _id, String firstname, String lastname, String userRole) {
        this._id = _id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.userRole = userRole;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return this._id.toHexString();
    }
}

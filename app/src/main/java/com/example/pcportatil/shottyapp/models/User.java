package com.example.pcportatil.shottyapp.models;

/**
 * Created by PC portatil on 17/06/2017.
 */

public class User {
    String _id ;
    String username, password, email;


    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }


    public User(String password, String username) {
        this.password = password;
        this.username = username;
    }


    public String get_Id() {
        return _id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public void set_Id(String _id) {
        this._id = _id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

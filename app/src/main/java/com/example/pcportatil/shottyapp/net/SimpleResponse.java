package com.example.pcportatil.shottyapp.net;

import com.example.pcportatil.shottyapp.models.User;

/**
 * Created by PC portatil on 17/06/2017.
 */

public class SimpleResponse {
    boolean success;
    String msg;
    User user;


    public User usersget(){
        return user;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

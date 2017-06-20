package com.example.pcportatil.shottyapp.net;

/**
 * Created by PC portatil on 17/06/2017.
 */

public class RegisterResponse extends SimpleResponse {
    boolean exist;


    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

}

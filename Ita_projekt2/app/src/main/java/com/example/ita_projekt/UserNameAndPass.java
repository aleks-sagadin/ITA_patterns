package com.example.ita_projekt;

import androidx.room.PrimaryKey;

import java.util.logging.Logger;


public class UserNameAndPass {

    @PrimaryKey(autoGenerate = true)
    int _id;
    String username;
    String password;
    String repassword;


    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }


    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public UserNameAndPass() {
        System.out.println("Createing heavy");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Exception caught" + e);
        }
        System.out.println("Heavy created");
    }

}

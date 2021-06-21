package com.example.ita_projekt;

public class User {

    private  UserNameAndPass userNameAndPass;

    public User() {
        System.out.println("HolderNative created");
    }

    public UserNameAndPass getUserNameAndPass() {

        if (userNameAndPass == null) {
            userNameAndPass = new UserNameAndPass();
        }

        return userNameAndPass;
    }
}

package com.example.libary;

public class Member {

    private String username;
    private String password;
    private boolean admin;


    public Member(String name, String password, boolean admin) {
        this.username = name;
        this.password = password;
        this.admin = admin;
    }

    public String getName() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean getAdmin() {
        return admin;
    }
}

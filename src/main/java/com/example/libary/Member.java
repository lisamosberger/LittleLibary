package com.example.libary;

public class Member {

    private String username;
    private String password;
    // for later, true if admin rights and false if user rights
    private boolean admin;


    public Member(String Username, String password, boolean admin) {
        this.username = Username;
        this.password = password;
        this.admin = admin;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean getAdmin() {
        return admin;
    }

    //Check if password is right
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}

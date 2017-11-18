package com.example.son.gdghack;

/**
 * Created by hoang on 11/18/2017.
 */

public class User {
    public String uid;
    public String email;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String username, String email) {
        this.uid = uid;
        this.email = email;
    }
}

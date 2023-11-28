package com.galmv.factories;

import com.galmv.entities.User;

public interface UserFactory {
    public User createUser(String name, String email, String password, String phone, String status, String photo);
}

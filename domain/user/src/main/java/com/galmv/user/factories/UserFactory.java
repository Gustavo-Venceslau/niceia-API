package com.galmv.user.factories;

import com.galmv.user.entities.User;

public interface UserFactory {
    public User createUser(String name, String email, String password, String phone, String status, String photo);
}

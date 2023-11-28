package com.galmv.factories;

import com.galmv.entities.CommonUser;
import com.galmv.entities.User;

public class CommonUserFactory implements UserFactory{

    @Override
    public User createUser(String name, String email, String password, String phone, String status, String photo) {
        return new CommonUser.Builder()
                .setName(name)
                .setEmail(email)
                .setPassword(password)
                .setPhone(phone)
                .setStatus(status)
                .setPhoto(photo)
                .build();
    }
}

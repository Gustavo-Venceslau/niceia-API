package com.galmv.ports;

import com.galmv.models.UserRequestModel;
import com.galmv.models.UserResponseModel;
import com.galmv.user.entities.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    public Optional<User> findByName(final String name);
    public Optional<User> findByEmail(final String email);
    public User create(User request);
    public UserResponseModel update(UUID userId, UserRequestModel request);
    public void delete(UUID userId);

}

package com.galmv.repository;

import com.galmv.models.UserRequestModel;
import com.galmv.models.UserResponseModel;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    public Optional<UserResponseModel> findByName(final String name);
    public UserResponseModel create(UserRequestModel request);
    public UserResponseModel update(UUID userId, UserRequestModel request);
    public void delete(UUID userId);

}

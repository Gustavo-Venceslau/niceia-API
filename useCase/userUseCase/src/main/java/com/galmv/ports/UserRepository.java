package com.galmv.ports;

import com.galmv.models.UserRequestModel;
import com.galmv.models.UserResponseModel;
import com.galmv.user.entities.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    Optional<User> findByName(final String name);
    Optional<User> findByEmail(final String email);
    Optional<User> findById(final UUID userid);
    User create(User request);
    User update(User user);
    void delete(UUID userId);

}

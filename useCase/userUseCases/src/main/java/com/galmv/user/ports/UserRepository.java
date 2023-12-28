package com.galmv.user.ports;

import com.galmv.user.entities.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {

    Optional<User> findByName(final String name);
    Optional<User> findByEmail(final String email);
    Optional<User> findById(final UUID userid);
    User create(User request);
    User update(User user);
    void deleteById(UUID userId);

}

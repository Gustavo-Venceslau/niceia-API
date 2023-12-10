package com.galmv.utils;

import com.galmv.models.UserRequestModel;
import com.galmv.models.UserResponseModel;
import com.galmv.ports.UserRepository;
import com.galmv.user.entities.User;
import com.galmv.user.factories.CommonUserFactory;
import com.galmv.user.factories.UserFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class InMemoryRepository implements UserRepository {

    private final Map<UUID, User> inMemoryDb = new HashMap<>();

    @Override
    public Optional<User> findByName(String name) {
        Optional<User> optionalUser = inMemoryDb.values().stream()
                .filter(user -> user.getName().equals(name))
                .findAny();

        return optionalUser;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> optionalUser = inMemoryDb.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findAny();

        return optionalUser;
    }

    @Override
    public User create(User user) {

        inMemoryDb.put(user.getId(), user);

        return user;
    }

    @Override
    public UserResponseModel update(UUID userId, UserRequestModel request) {
        return null;
    }

    @Override
    public void delete(UUID userId) {
        this.inMemoryDb.remove(userId);
    }
}

package com.galmv.repositories;

import com.galmv.models.UserRequestModel;
import com.galmv.repository.UserRepository;
import com.galmv.models.UserResponseModel;
import com.galmv.user.constants.Errors;
import com.galmv.user.entities.User;
import com.galmv.user.exceptions.custom.UserNotFoundException;
import com.galmv.user.factories.CommonUserFactory;
import com.galmv.user.factories.UserFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class InMemoryRepository implements UserRepository {

    private final Map<UUID, User> inMemoryDb = new HashMap<>();
    private final UserFactory factory = new CommonUserFactory();

    @Override
    public Optional<UserResponseModel> findByName(String name) {
        Optional<User> optionalUser = inMemoryDb.values().stream()
                .filter(user -> user.getName().equals(name))
                .findAny();

        User userFound = optionalUser.get();

        UserResponseModel response = new UserResponseModel(
                userFound.getName(),
                userFound.getEmail(),
                userFound.getPassword(),
                userFound.getPhone(),
                userFound.getStatus(),
                userFound.getPhoto()
        );

        return Optional.of(response);
    }

    @Override
    public UserResponseModel create(UserRequestModel request) {
        User user = factory.createUser(
                request.name(),
                request.email(),
                request.password(),
                request.phone(),
                request.status(),
                request.photo()
        );

        inMemoryDb.put(user.getId(), user);

        return new UserResponseModel(
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getPhone(),
                user.getStatus(),
                user.getPhoto()
        );
    }

    @Override
    public UserResponseModel update(UUID userId, UserRequestModel request) {
        return null;
    }

    @Override
    public void delete(UUID userId) {

    }
}

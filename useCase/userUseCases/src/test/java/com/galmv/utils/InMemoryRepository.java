package com.galmv.utils;

import com.galmv.models.UserResponseModel;
import com.galmv.ports.UserRepository;
import com.galmv.user.entities.User;

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
    public Optional<User> findById(UUID userId) {
        Optional<User> optionalUser = inMemoryDb.values().stream()
                .filter(user -> user.getId() == userId).findAny();

        return optionalUser;
    }

    @Override
    public User create(User user) {

        inMemoryDb.put(user.getId(), user);

        return user;
    }

    @Override
    public User update(User user) {
       this.inMemoryDb.put(user.getId(), user);

       Optional<User> updatedUser = this.inMemoryDb.values().stream()
               .filter(userToFind -> userToFind.getId() == user.getId())
               .findAny();

       return updatedUser.get();
    }

    @Override
    public void deleteById(UUID userId) {
        this.inMemoryDb.remove(userId);
    }
}

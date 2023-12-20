package com.galmv.useCases.deleteUser;

import com.galmv.ports.UserRepository;
import com.galmv.user.constants.UserErrors;
import com.galmv.user.entities.User;
import com.galmv.user.exceptions.UserNotFoundException;

import java.util.Optional;
import java.util.UUID;

public class DeleteUserById implements DeleteUser{

    private final UserRepository repository;

    public DeleteUserById(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public void executeWith(UUID userId) {
        Optional<User> optionalUser = this.repository.findById(userId);

        if(optionalUser.isEmpty()) throw new UserNotFoundException(UserErrors.USER_NOT_FOUND_TO_DELETE);

        this.repository.deleteById(userId);
    }
}

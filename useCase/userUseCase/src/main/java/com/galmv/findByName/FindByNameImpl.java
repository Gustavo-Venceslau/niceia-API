package com.galmv.findByName;

import com.galmv.repository.UserRepository;
import com.galmv.models.UserResponseModel;
import com.galmv.user.constants.Errors;
import com.galmv.user.exceptions.custom.UserNotFoundException;

import java.util.Optional;

public class FindByNameImpl implements FindByName{

    private final UserRepository repository;

    public FindByNameImpl(UserRepository repository){
        this.repository = repository;
    }

    @Override
    public UserResponseModel find(String name) {
        Optional<UserResponseModel> optionalUser = repository.findByName(name);

        if(optionalUser.isEmpty()) throw new UserNotFoundException(Errors.USER_NOT_FOUND);

        return optionalUser.get();
    }
}

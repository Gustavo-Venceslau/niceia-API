package com.galmv.user.useCases.findByName;

import com.galmv.user.ports.UserRepository;
import com.galmv.user.models.UserResponseModel;
import com.galmv.user.presenters.UserPresenter;
import com.galmv.user.constants.UserErrors;
import com.galmv.user.entities.User;
import com.galmv.user.exceptions.UserNotFoundException;

import java.util.Optional;

public class FindByNameUseCase implements FindByName {

    private final UserRepository repository;
    private final UserPresenter presenter;

    public FindByNameUseCase(UserRepository repository, UserPresenter presenter){
        this.repository = repository;
        this.presenter = presenter;
    }

    @Override
    public UserResponseModel findBy(String name) {
        Optional<User> optionalUser = repository.findByName(name);

        if(optionalUser.isEmpty()) throw new UserNotFoundException(UserErrors.USER_NOT_FOUND);

        return presenter.prepareSuccessView(optionalUser.get());
    }
}

package com.galmv.useCases.createUser;

import com.galmv.models.UserRequestModel;
import com.galmv.models.UserResponseModel;
import com.galmv.ports.PasswordEncoder;
import com.galmv.ports.UserRepository;
import com.galmv.presenters.UserPresenter;
import com.galmv.user.constants.Errors;
import com.galmv.user.entities.User;
import com.galmv.user.exceptions.custom.UserAlreadyExistsException;
import com.galmv.user.factories.CommonUserFactory;

import java.util.Optional;

public class CreateUserUseCase implements CreateUser{

    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final UserPresenter presenter;

    public CreateUserUseCase(UserRepository repository, PasswordEncoder encoder, UserPresenter presenter) {
        this.repository = repository;
        this.encoder = encoder;
        this.presenter = presenter;
    }

    @Override
    public UserResponseModel create(UserRequestModel request) {
        Optional<User> optionalUser = this.repository.findByEmail(request.email());

        if(optionalUser.isPresent()) throw new UserAlreadyExistsException(Errors.USER_ALREADY_EXISTS);

        User userToSave = new CommonUserFactory().createUser(
                request.name(),
                request.email(),
                encoder.encode(request.password()),
                request.phone(),
                request.status(),
                request.photo()
        );

        User response = this.repository.create(userToSave);

        return presenter.prepareSuccessView(response);
    }
}

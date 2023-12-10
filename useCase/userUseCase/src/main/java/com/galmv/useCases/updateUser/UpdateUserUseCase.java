package com.galmv.useCases.updateUser;

import com.galmv.models.UserRequestModel;
import com.galmv.models.UserResponseModel;
import com.galmv.ports.PasswordEncoder;
import com.galmv.ports.UserRepository;
import com.galmv.presenters.UserPresenter;
import com.galmv.user.constants.Errors;
import com.galmv.user.entities.User;
import com.galmv.user.exceptions.custom.UserNotFoundException;

import java.util.Optional;
import java.util.UUID;

public class UpdateUserUseCase implements UpdateUser{

    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final UserPresenter presenter;

    public UpdateUserUseCase(UserRepository repository, PasswordEncoder encoder, UserPresenter presenter) {
        this.repository = repository;
        this.encoder = encoder;
        this.presenter = presenter;
    }

    @Override
    public UserResponseModel executeWith(UUID userId, UserRequestModel newData) {
        Optional<User> optionalUser = this.repository.findById(userId);

        if(optionalUser.isEmpty()) throw new UserNotFoundException(Errors.USER_NOT_FOUND_TO_UPDATE);

        User userToUpdate = optionalUser.get();

        updateUserDataWith(userToUpdate, newData);

        User updatedUser = this.repository.update(userToUpdate);

        return presenter.prepareSuccessView(updatedUser);
    }

    private void updateUserDataWith(User userToUpdate, UserRequestModel newData) {
        userToUpdate.setName(newData.name());
        userToUpdate.setEmail(newData.email());
        userToUpdate.setPassword(encoder.encode(newData.password()));
        userToUpdate.setPhone(newData.phone());
        userToUpdate.setStatus(newData.status());
        userToUpdate.setPhoto(newData.photo());
    }
}

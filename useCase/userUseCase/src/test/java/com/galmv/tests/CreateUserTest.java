package com.galmv.tests;

import com.galmv.config.UnitTestConfig;
import com.galmv.models.UserRequestModel;
import com.galmv.models.UserResponseModel;
import com.galmv.ports.PasswordEncoder;
import com.galmv.user.constants.Errors;
import com.galmv.user.exceptions.UserAlreadyExistsException;
import com.galmv.useCases.createUser.CreateUser;
import com.galmv.useCases.createUser.CreateUserUseCase;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CreateUserTest extends UnitTestConfig {
    private final PasswordEncoder encoder;
    private final CreateUser createUserUseCase;

    public CreateUserTest(){
        this.encoder = password -> password;
        this.createUserUseCase = new CreateUserUseCase(repository, encoder, presenter);
    }

    @Test
    public void givenNewUserInformation_whenCreated_thenUserMustBeValid(){
        UserRequestModel requestModel = new UserRequestModel(
                "John Doe",
                "johnDoe@mail.com",
                "123",
                "12345678910",
                "happy",
                "url"
        );

        UserResponseModel responseModel = this.createUserUseCase.create(requestModel);

        assertThat(responseModel.id()).isNotNull();
        assertThat(responseModel.name()).isEqualTo(requestModel.name());
        assertThat(responseModel.email()).isEqualTo(requestModel.email());
        assertThat(responseModel.password()).isEqualTo(requestModel.password());
        assertThat(responseModel.phone()).isEqualTo(requestModel.phone());
        assertThat(responseModel.status()).isEqualTo(requestModel.status());
        assertThat(responseModel.photo()).isEqualTo(requestModel.photo());
    }

    @Test
    public void givenNewUserInformation_whenEmailAlreadyExists_thenMustBeNotPossibleToCreateUser(){
        UserRequestModel requestModel = new UserRequestModel(
                "John Doe",
                "john@mail.com",
                "123",
                "12345678910",
                "happy",
                "url"
        );

        this.repository.create(user);

        assertThatExceptionOfType(UserAlreadyExistsException.class).isThrownBy(() ->
                this.createUserUseCase.create(requestModel)).withMessage(Errors.USER_ALREADY_EXISTS);
    }
}

package com.galmv.tests;

import com.galmv.config.UnitTestConfig;
import com.galmv.models.UserRequestModel;
import com.galmv.models.UserResponseModel;
import com.galmv.ports.PasswordEncoder;
import com.galmv.useCases.updateUser.UpdateUser;
import com.galmv.useCases.updateUser.UpdateUserUseCase;
import com.galmv.user.constants.Errors;
import com.galmv.user.exceptions.custom.UserNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

public class UpdateUserTest extends UnitTestConfig {

    private final UpdateUser updateUserUseCase;
    private final PasswordEncoder encoder;

    public UpdateUserTest(){
        this.encoder = password -> password;
        this.updateUserUseCase = new UpdateUserUseCase(repository, encoder, presenter);
    }

    @Test
    public void givenAnUserIdAndNewData_whenUsedToUpdateAnUser_thenUserMustHaveNewData(){
        UserRequestModel newData = new UserRequestModel(
                "João",
                "joão@mail.com",
                "321",
                "10987654321",
                "Sad",
                "url"
        );

        UserResponseModel responseModel = this.updateUserUseCase.executeWith(user.getId(), newData);

        assertThat(responseModel.id()).isNotNull();
        assertThat(responseModel.name()).isEqualTo(newData.name());
        assertThat(responseModel.email()).isEqualTo(newData.email());
        assertThat(responseModel.password()).isEqualTo(newData.password());
        assertThat(responseModel.phone()).isEqualTo(newData.phone());
        assertThat(responseModel.status()).isEqualTo(newData.status());
    }

    @Test
    public void givenAnInvalidId_whenTryToUpdate_thenMustThrowException(){
        UserRequestModel newData = new UserRequestModel(
                "João",
                "joão@mail.com",
                "321",
                "10987654321",
                "Sad",
                "url"
        );

        assertThatExceptionOfType(UserNotFoundException.class).isThrownBy(() ->
                this.updateUserUseCase.executeWith(UUID.randomUUID(), newData)).withMessage(Errors.USER_NOT_FOUND_TO_UPDATE);
    }
}

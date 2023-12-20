package com.galmv.tests;

import com.galmv.config.UnitTestConfig;
import com.galmv.useCases.deleteUser.DeleteUser;
import com.galmv.useCases.deleteUser.DeleteUserById;
import com.galmv.user.constants.UserErrors;
import com.galmv.user.entities.User;
import com.galmv.user.exceptions.UserNotFoundException;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

public class DeleteUserByIdTest extends UnitTestConfig {

    private final DeleteUser deleteUserUseCase;

    public DeleteUserByIdTest(){
        this.deleteUserUseCase = new DeleteUserById(repository);
    }

    @Test
    public void givenAnUser_whenDeletedById_thenUserMustNotExists(){
        this.deleteUserUseCase.executeWith(user.getId());

        Optional<User> userFound = this.repository.findById(user.getId());

        assertThat(userFound.isEmpty()).isTrue();
    }

    @Test
    public void givenInvalidUserId_whenTryToDelete_thenMustThrowException(){
        assertThatExceptionOfType(UserNotFoundException.class).isThrownBy(() ->
                this.deleteUserUseCase.executeWith(UUID.randomUUID())).withMessage(UserErrors.USER_NOT_FOUND_TO_DELETE);
    }
}

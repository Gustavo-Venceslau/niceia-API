package com.galmv.tests;

import com.galmv.chat.entities.Chat;
import com.galmv.chat.useCases.removeChatUser.RemoveChatUser;
import com.galmv.chat.useCases.removeChatUser.RemoveChatUserUseCase;
import com.galmv.chat.useCases.removeChatUser.models.RemoveChatUserRequestModel;
import com.galmv.config.UnitTestConfig;
import com.galmv.user.constants.UserErrors;
import com.galmv.user.entities.User;
import com.galmv.user.exceptions.UserNotFoundException;
import com.galmv.user.factories.CommonUserFactory;
import com.galmv.user.factories.UserFactory;
import com.galmv.user.ports.UserRepository;
import com.galmv.utils.UserInMemoryRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

public class RemoveChatUserTest extends UnitTestConfig {

    private final RemoveChatUser useCase;
    private final UserRepository userRepository;
    private final UserFactory userFactory;

    public RemoveChatUserTest(){
        this.userFactory = new CommonUserFactory();
        this.userRepository = new UserInMemoryRepository();
        this.useCase = new RemoveChatUserUseCase(repository, userRepository);
    }

    @Test
    public void givenBothValidChatAndUser_whenTriedToRemoveChatUser_thenUserMustBeRemoved(){
        User user = userFactory.createUser(
                "John Doe",
                "john@mail.com",
                "123",
                "12345678910",
                "occupied",
                "url"
        );

        this.userRepository.create(user);

        this.repository.addUserToChat(groupChat.getId(), user);

        RemoveChatUserRequestModel request = new RemoveChatUserRequestModel(groupChat.getId(), user.getId());

        this.useCase.remove(request);

        Optional<Chat> chatFound = this.repository.findById(groupChat.getId());

        assertThat(chatFound.get().getParticipants().size()).isEqualTo(0);
    }

    @Test
    public void givenInvalidUserId_whenTriedToRemoveChatUser_thenThrowUserNotFoundException(){
        RemoveChatUserRequestModel request = new RemoveChatUserRequestModel(groupChat.getId(), UUID.randomUUID());

        assertThatExceptionOfType(UserNotFoundException.class).isThrownBy(() ->
                this.useCase.remove(request)).withMessage(UserErrors.USER_NOT_FOUND);
    }

    @Test
    public void givenInvalidChatId_whenTriedToRemoveChatUser_thenThrowChatNotFoundException(){
        User user = userFactory.createUser(
                "John Doe",
                "john@mail.com",
                "123",
                "12345678910",
                "occupied",
                "url"
        );

        RemoveChatUserRequestModel request = new RemoveChatUserRequestModel(UUID.randomUUID(), user.getId());

        assertThatExceptionOfType(UserNotFoundException.class).isThrownBy(() ->
                this.useCase.remove(request)).withMessage(UserErrors.USER_NOT_FOUND);
    }
}

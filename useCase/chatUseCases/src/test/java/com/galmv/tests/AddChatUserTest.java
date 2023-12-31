package com.galmv.tests;

import com.galmv.chat.entities.Chat;
import com.galmv.chat.useCases.addChatUser.AddChatUserUseCase;
import com.galmv.chat.useCases.addChatUser.models.AddChatUserRequestModel;
import com.galmv.config.UnitTestConfig;
import com.galmv.user.entities.User;
import com.galmv.user.factories.CommonUserFactory;
import com.galmv.user.factories.UserFactory;
import com.galmv.user.ports.UserRepository;
import com.galmv.utils.UserInMemoryRepository;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;


public class AddChatUserTest extends UnitTestConfig {

    private final AddChatUserUseCase useCase;
    private final UserRepository userRepository;
    private final UserFactory userFactory;

    public AddChatUserTest(){
        this.userRepository = new UserInMemoryRepository();
        this.useCase = new AddChatUserUseCase(repository, userRepository);
        this.userFactory = new CommonUserFactory();
    }

    @Test
    public void givenAnUser_whenTriedToAddToChat_thenUserMustBeAdded(){
        User user = userFactory.createUser(
                "John Doe",
                "john@mail.com",
                "123",
                "12345678910",
                "occupied",
                "url"
        );

        this.userRepository.create(user);

        AddChatUserRequestModel request = new AddChatUserRequestModel(user.getId(), groupChat.getId());

        this.useCase.add(request);

        Optional<Chat> chatUserWasAdded = this.repository.findById(groupChat.getId());

        assertThat(chatUserWasAdded.get().getParticipants().contains(user)).isTrue();
    }
}

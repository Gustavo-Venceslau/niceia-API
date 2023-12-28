package com.galmv.tests;

import com.galmv.config.UnitTestConfig;
import com.galmv.user.ports.UserRepository;
import com.galmv.chat.useCases.findAllByUser.FindAllByUser;
import com.galmv.chat.useCases.findAllByUser.FindAllByUserUseCase;
import com.galmv.chat.useCases.findAllByUser.models.FindAllRequestModel;
import com.galmv.chat.useCases.findAllByUser.models.FindAllResponseModel;
import com.galmv.chat.useCases.findAllByUser.presenters.FindAllByUserPresenter;
import com.galmv.chat.useCases.findAllByUser.presenters.FindAllByUserPresenterView;
import com.galmv.user.constants.UserErrors;
import com.galmv.user.entities.User;
import com.galmv.user.exceptions.UserNotFoundException;
import com.galmv.user.factories.CommonUserFactory;
import com.galmv.user.factories.UserFactory;
import com.galmv.utils.UserInMemoryRepository;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

public class FindAllByUserTest extends UnitTestConfig {

    private final FindAllByUser useCase;
    private final FindAllByUserPresenter presenter;

    private final UserRepository userRepository;
    private final UserFactory userFactory;

    public FindAllByUserTest(){
        this.userRepository = new UserInMemoryRepository();
        this.userFactory = new CommonUserFactory();
        this.presenter = new FindAllByUserPresenterView();
        this.useCase = new FindAllByUserUseCase(repository, presenter, userRepository);
    }

    @Test
    public void givenAnUserId_whenUsedToFindChats_thenUserChatListMustBeReturned(){
        User user = this.userFactory.createUser(
                "john",
                "john@mail.com",
                "123",
                "12345678910",
                "happy",
                "url"
        );

        this.userRepository.create(user);

        this.repository.addUserToChat(groupChat.getId(), user);
        this.repository.addUserToChat(privateChat.getId(), user);

        FindAllRequestModel request = new FindAllRequestModel(user.getId());

        FindAllResponseModel listOfChats = this.useCase.find(request);

        assertThat(listOfChats.chats().size()).isEqualTo(2);
    }

    @Test
    public void givenAnInvalidUserId_whenUsedToFindChats_thenThrowException(){
        FindAllRequestModel request = new FindAllRequestModel(UUID.randomUUID());

        assertThatExceptionOfType(UserNotFoundException.class).isThrownBy(() ->
                this.useCase.find(request)).withMessage(UserErrors.USER_NOT_FOUND);
    }
}

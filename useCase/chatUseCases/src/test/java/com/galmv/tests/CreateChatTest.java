package com.galmv.tests;

import com.galmv.config.UnitTestConfig;
import com.galmv.message.entities.Message;
import com.galmv.models.GroupChatRequestModel;
import com.galmv.models.GroupChatResponseModel;
import com.galmv.models.PrivateChatRequestModel;
import com.galmv.models.PrivateChatResponseModel;
import com.galmv.presenters.ChatPresenter;
import com.galmv.presenters.ChatPresenterView;
import com.galmv.useCases.createChat.CreateChat;
import com.galmv.useCases.createChat.CreateChatUseCase;
import com.galmv.user.entities.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CreateChatTest extends UnitTestConfig {

    private final CreateChat createChat;
    private final ChatPresenter presenter;

    public CreateChatTest(){
        this.presenter = new ChatPresenterView();
        this.createChat = new CreateChatUseCase(repository, presenter);
    }

    @Test
    public void givenAPrivateChatData_whenUsedToCreateChat_thenChatMustBeCreated(){
        List<User> participants = new ArrayList<>();
        List<Message> messages = new ArrayList<>();

        PrivateChatRequestModel request = new PrivateChatRequestModel(
                participants,
                messages
        );

        PrivateChatResponseModel chat = this.createChat.createPrivateChat(request);

        assertThat(chat.participants()).isEqualTo(participants);
        assertThat(chat.messages()).isEqualTo(messages);
    }

    @Test
    public void givenAGroupChatData_whenUsedToCreateChat_thenChatMustBeCreated(){
        List<User> participants = new ArrayList<>();
        List<Message> messages = new ArrayList<>();
        List<User> admins = new ArrayList<>();

        GroupChatRequestModel request = new GroupChatRequestModel(
                participants,
                messages,
                admins,
                "Family",
                "Family Group",
                "url",
                false
        );

        GroupChatResponseModel chat = this.createChat.createGroupChat(request);

        assertThat(chat.participants()).isEqualTo(request.participants());
        assertThat(chat.messages()).isEqualTo(request.messages());
        assertThat(chat.admins()).isEqualTo(request.admins());
        assertThat(chat.name()).isEqualTo(request.name());
        assertThat(chat.description()).isEqualTo(request.description());
        assertThat(chat.photo()).isEqualTo(request.photo());
        assertThat(chat.archived()).isEqualTo(request.archived());
    }
}

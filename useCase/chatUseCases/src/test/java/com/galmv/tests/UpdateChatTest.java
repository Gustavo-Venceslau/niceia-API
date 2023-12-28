package com.galmv.tests;

import com.galmv.chat.exceptions.ChatNotFoundException;
import com.galmv.config.UnitTestConfig;
import com.galmv.message.entities.Message;
import com.galmv.chat.models.GroupChatRequestModel;
import com.galmv.chat.models.GroupChatResponseModel;
import com.galmv.chat.models.PrivateChatRequestModel;
import com.galmv.chat.presenters.ChatPresenter;
import com.galmv.chat.presenters.ChatPresenterView;
import com.galmv.chat.useCases.updateChat.UpdateChat;
import com.galmv.chat.useCases.updateChat.UpdateChatUseCase;
import com.galmv.user.entities.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

public class UpdateChatTest extends UnitTestConfig {

    private final UpdateChat useCase;
    private final ChatPresenter presenter;

    public UpdateChatTest(){
        this.presenter = new ChatPresenterView();
        this.useCase = new UpdateChatUseCase(repository, presenter);
    }

    @Test
    public void givenAGroupChatData_whenUpdated_thenGroupChatMustBeUpdated(){
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

        GroupChatResponseModel response = this.useCase.updateGroupChat(groupChat.getId(), request);

        assertThat(response.participants()).isEqualTo(request.participants());
        assertThat(response.messages()).isEqualTo(request.messages());
        assertThat(response.admins()).isEqualTo(request.admins());
        assertThat(response.name()).isEqualTo(request.name());
        assertThat(response.description()).isEqualTo(request.description());
        assertThat(response.photo()).isEqualTo(request.photo());
        assertThat(response.archived()).isEqualTo(request.archived());
    }

    @Test
    public void givenAnWrongChatId_whenUpdated_thenThrowAnException(){
        List<User> participants = new ArrayList<>();
        List<Message> messages = new ArrayList<>();
        List<User> admins = new ArrayList<>();

        GroupChatRequestModel groupChatRequest = new GroupChatRequestModel(
                participants,
                messages,
                admins,
                "Family",
                "Family Group",
                "url",
                false
        );

        PrivateChatRequestModel privateChatRequest = new PrivateChatRequestModel(
                participants,
                messages
        );

        assertThatExceptionOfType(ChatNotFoundException.class).isThrownBy(() ->
                this.useCase.updateGroupChat(UUID.randomUUID(), groupChatRequest));
    }
}

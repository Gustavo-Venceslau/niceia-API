package com.galmv.tests;

import com.galmv.chat.constants.ChatErrors;
import com.galmv.chat.exceptions.ChatNotFoundException;
import com.galmv.chat.useCases.findByName.FindByName;
import com.galmv.chat.useCases.findByName.FindByNameUseCase;
import com.galmv.config.UnitTestConfig;
import com.galmv.chat.models.GroupChatResponseModel;
import com.galmv.chat.presenters.ChatPresenter;
import com.galmv.chat.presenters.ChatPresenterView;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class FindByNameTest extends UnitTestConfig {

    private final FindByName findByName;
    private final ChatPresenter presenter;

    public FindByNameTest(){
        this.presenter = new ChatPresenterView();
        this.findByName = new FindByNameUseCase(repository, presenter);
    }

    @Test
    public void givenAChatName_whenFindByName_thenChatMustBeNotNull(){
        GroupChatResponseModel chat = this.findByName.findBy(groupChat.getName());

        assertThat(chat).isNotNull();
        assertThat(chat.participants()).isEqualTo(groupChat.getParticipants());
        assertThat(chat.messages()).isEqualTo(groupChat.getMessages());
        assertThat(chat.name()).isEqualTo(groupChat.getName());
        assertThat(chat.description()).isEqualTo(groupChat.getDescription());
        assertThat(chat.photo()).isEqualTo(groupChat.getPhoto());
        assertThat(chat.archived()).isEqualTo(groupChat.isArchived());
    }

    @Test
    public void givenInvalidChatName_whenFindByName_thenThrowException(){
        assertThatExceptionOfType(ChatNotFoundException.class)
                .isThrownBy(() -> this.findByName.findBy("any")).withMessage(ChatErrors.CHAT_NOT_FOUND);
    }
}

package com.galmv.tests;

import com.galmv.chat.constants.ChatErrors;
import com.galmv.chat.entities.Chat;
import com.galmv.chat.exceptions.ChatNotFoundException;
import com.galmv.config.UnitTestConfig;
import com.galmv.chat.useCases.deleteChat.DeleteChat;
import com.galmv.chat.useCases.deleteChat.DeleteChatUseCase;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

public class DeleteChatTest extends UnitTestConfig {

    private final DeleteChat useCase;

    public DeleteChatTest(){
        this.useCase = new DeleteChatUseCase(repository);
    }

    @Test
    public void givenAChatId_whenDeletedById_thenChatMustNotExists(){
        this.useCase.deleteBy(privateChat.getId());
        this.useCase.deleteBy(groupChat.getId());

        Optional<Chat> optionalPrivateChat = this.repository.findById(privateChat.getId());
        Optional<Chat> optionalGroupChat = this.repository.findById(groupChat.getId());

        assertThat(optionalPrivateChat.isEmpty()).isTrue();
        assertThat(optionalGroupChat.isEmpty()).isTrue();
    }

    @Test
    public void givenAnInvalidChatId_whenDeletedById_thenThrowAnException(){
        assertThatExceptionOfType(ChatNotFoundException.class).isThrownBy(() ->
                this.useCase.deleteBy(UUID.randomUUID())).withMessage(ChatErrors.CHAT_NOT_FOUND);
    }
}

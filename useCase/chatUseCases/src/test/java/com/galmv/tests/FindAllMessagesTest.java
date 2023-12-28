package com.galmv.tests;

import com.galmv.chat.constants.ChatErrors;
import com.galmv.chat.exceptions.ChatNotFoundException;
import com.galmv.chat.useCases.findAllMessages.FindAllMessages;
import com.galmv.chat.useCases.findAllMessages.FindAllMessagesUseCase;
import com.galmv.chat.useCases.findAllMessages.model.FindAllMessagesResponseModel;
import com.galmv.chat.useCases.findAllMessages.presenters.FindAllMessagesPresenter;
import com.galmv.chat.useCases.findAllMessages.presenters.FindAllMessagesPresenterView;
import com.galmv.config.UnitTestConfig;
import com.galmv.message.entities.Message;
import com.galmv.message.enums.MessageType;
import com.galmv.message.factories.MessageFactory;
import com.galmv.message.factories.TextMessageFactory;
import com.galmv.user.entities.User;
import com.galmv.user.factories.CommonUserFactory;
import com.galmv.user.factories.UserFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

public class FindAllMessagesTest extends UnitTestConfig {

    private final FindAllMessages useCase;
    private final MessageFactory messageFactory;
    private final UserFactory userFactory;
    private final FindAllMessagesPresenter presenter;


    public FindAllMessagesTest(){
        this.userFactory = new CommonUserFactory();
        this.messageFactory = new TextMessageFactory();
        this.presenter = new FindAllMessagesPresenterView();
        this.useCase = new FindAllMessagesUseCase(repository, presenter);
    }

    @Test
    public void givenAChatId_whenTriedToFoundAllMessages_thenAllMessagesMustBeReturned(){
        User user = userFactory.createUser(
                "John Doe",
                "john@mail.com",
                "123",
                "12345678910",
                "occupied",
                "url"
        );

        LocalDateTime sentAt = LocalDateTime.now();
        LocalDateTime deliveredAt = LocalDateTime.now();
        LocalDateTime seenAt = LocalDateTime.now();

        Message message1 = messageFactory.createMessage(
                "olá amigo",
                MessageType.CHAT,
                sentAt,
                deliveredAt,
                seenAt,
                user.getId(),
                privateChat.getId(),
                null
        );

        Message message2 = messageFactory.createMessage(
                "tudo bem?",
                MessageType.CHAT,
                sentAt,
                deliveredAt,
                seenAt,
                user.getId(),
                privateChat.getId(),
                null
        );

        privateChat.addMessages(message1);
        privateChat.addMessages(message2);

        FindAllMessagesResponseModel messagesFound = this.useCase.findAllBy(privateChat.getId());

        assertThat(messagesFound.messages().size()).isEqualTo(2);
        assertThat(messagesFound.messages().get(0).getContent()).isEqualTo(message1.getContent());
        assertThat(messagesFound.messages().get(1).getContent()).isEqualTo(message2.getContent());
    }

    @Test
    public void givenAnInvalidChatId_WhenTriedToFoundAllMessages_thenThrowException(){
        assertThatExceptionOfType(ChatNotFoundException.class).isThrownBy(() ->
                this.useCase.findAllBy(UUID.randomUUID())).withMessage(ChatErrors.CHAT_NOT_FOUND);
    }
}

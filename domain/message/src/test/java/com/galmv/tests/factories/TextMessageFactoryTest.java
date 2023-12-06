package com.galmv.tests.factories;

import com.galmv.message.entities.Message;
import com.galmv.message.enums.MessageType;
import com.galmv.message.factories.MessageFactory;
import com.galmv.message.factories.TextMessageFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

public class TextMessageFactoryTest {
    private final MessageFactory factory;

    public TextMessageFactoryTest(){
        this.factory = new TextMessageFactory();
    }

    @Test
    public void givenNewMessage_whenBuiltByFactory_thenMessageMustBeNotNull(){
        UUID senderId = UUID.randomUUID();
        UUID chatId = UUID.randomUUID();
        UUID groupId = UUID.randomUUID();

        LocalDateTime sentAt = LocalDateTime.now();
        LocalDateTime deliveredAt = LocalDateTime.now();
        LocalDateTime seenAt = LocalDateTime.now();

        Message message = factory.createMessage(
                "olá amigo",
                MessageType.CHAT,
                sentAt,
                deliveredAt,
                seenAt,
                senderId,
                chatId,
                groupId
        );

        assertThat(message.getId()).isNotNull();
        assertThat(message.getContent()).isEqualTo("olá amigo");
        assertThat(message.getType()).isEqualTo(MessageType.CHAT);
        assertThat(message.getSentAt()).isEqualTo(sentAt);
        assertThat(message.getDeliveredAt()).isEqualTo(deliveredAt);
        assertThat(message.getSeenAt()).isEqualTo(seenAt);
        assertThat(message.getSenderId()).isEqualTo(senderId);
        assertThat(message.getChatId()).isEqualTo(chatId);
        assertThat(message.getGroupId()).isEqualTo(groupId);
    }
}

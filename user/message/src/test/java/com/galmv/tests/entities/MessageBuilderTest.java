package com.galmv.tests.entities;

import com.galmv.entities.Message;
import com.galmv.entities.TextMessage;
import com.galmv.enums.MessageType;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

public class MessageBuilderTest {

    @Test
    public void givenNewMessage_whenBuiltByBuilder_thenMessageInfoMustBeNotNull(){
        UUID senderId = UUID.randomUUID();
        UUID chatId = UUID.randomUUID();
        UUID groupId = UUID.randomUUID();

        LocalDateTime sentAt = LocalDateTime.now();
        LocalDateTime deliveredAt = LocalDateTime.now();
        LocalDateTime seenAt = LocalDateTime.now();

        Message message = new TextMessage.Builder()
                .setContent("olá amigo")
                .setType(MessageType.CHAT)
                .setSentAt(sentAt)
                .setDeliveredAt(deliveredAt)
                .setSeenAt(seenAt)
                .setSenderId(senderId)
                .setChatId(chatId)
                .setGroupId(groupId)
                .build();

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

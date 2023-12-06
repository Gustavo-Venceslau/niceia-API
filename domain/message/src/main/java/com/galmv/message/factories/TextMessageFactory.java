package com.galmv.message.factories;

import com.galmv.message.entities.Message;
import com.galmv.message.entities.TextMessage;
import com.galmv.message.enums.MessageType;

import java.time.LocalDateTime;
import java.util.UUID;

public class TextMessageFactory implements MessageFactory{
    @Override
    public Message createMessage(String content, MessageType type, LocalDateTime sentAt, LocalDateTime deliveredAt, LocalDateTime seenAt, UUID senderId, UUID chatId, UUID groupId) {
        return new TextMessage.Builder()
                .setContent(content)
                .setType(type)
                .setSentAt(sentAt)
                .setDeliveredAt(deliveredAt)
                .setSeenAt(seenAt)
                .setSenderId(senderId)
                .setChatId(chatId)
                .setGroupId(groupId)
                .build();
    }
}

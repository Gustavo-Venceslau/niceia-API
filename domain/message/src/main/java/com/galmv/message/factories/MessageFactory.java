package com.galmv.message.factories;

import com.galmv.message.entities.Message;
import com.galmv.message.enums.MessageType;

import java.time.LocalDateTime;
import java.util.UUID;

public interface MessageFactory {
    public Message createMessage(
                String content,
                MessageType type,
                LocalDateTime sentAt,
                LocalDateTime deliveredAt,
                LocalDateTime seenAt,
                UUID senderId,
                UUID chatId,
                UUID groupId
            );
}

package com.galmv.factories;

import com.galmv.entities.Message;
import com.galmv.enums.MessageType;

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

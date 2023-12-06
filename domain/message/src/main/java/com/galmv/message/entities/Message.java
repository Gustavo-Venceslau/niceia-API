package com.galmv.message.entities;

import com.galmv.message.enums.MessageType;

import java.time.LocalDateTime;
import java.util.UUID;

public interface Message {

    public UUID getId();
    public String getContent();
    public void setContent(String content);
    public MessageType getType();
    public void setType(MessageType type);
    public LocalDateTime getSentAt();
    public LocalDateTime getDeliveredAt();
    public LocalDateTime getSeenAt();
    public UUID getSenderId();
    public UUID getChatId();
    public UUID getGroupId();
}

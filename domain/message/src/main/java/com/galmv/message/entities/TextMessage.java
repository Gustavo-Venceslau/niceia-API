package com.galmv.message.entities;

import com.galmv.message.enums.MessageType;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class TextMessage implements Message{

    private UUID id;
    private String content;
    private MessageType type;
    private LocalDateTime sentAt;
    private LocalDateTime deliveredAt;
    private LocalDateTime seenAt;
    private UUID senderId;
    private UUID chatId;
    private UUID groupId;

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public String getContent() {
        return content;
    }

    @Override
    public void setContent(String content){
        this.content = content;
    }

    @Override
    public MessageType getType() {
        return type;
    }

    @Override
    public void setType(MessageType type) {
        this.type = type;
    }

    @Override
    public LocalDateTime getSentAt() {
        return sentAt;
    }

    @Override
    public LocalDateTime getDeliveredAt(){
        return deliveredAt;
    }

    @Override
    public LocalDateTime getSeenAt() {
        return seenAt;
    }

    @Override
    public UUID getSenderId() {
        return senderId;
    }

    @Override
    public UUID getChatId() {
        return chatId;
    }

    @Override
    public UUID getGroupId() {
        return groupId;
    }

    private TextMessage(Builder builder){
        this.id = UUID.randomUUID();
        this.content = builder.content;
        this.type = builder.type;
        this.sentAt = builder.sentAt;
        this.deliveredAt = builder.deliveredAt;
        this.seenAt = builder.seenAt;
        this.senderId = builder.senderId;
        this.chatId = builder.chatId;
        this.groupId = builder.groupId;
    }

    public static class Builder{
        private String content;
        private MessageType type;
        private LocalDateTime sentAt;
        private LocalDateTime deliveredAt;
        private LocalDateTime seenAt;
        private UUID senderId;
        private UUID chatId;
        private UUID groupId;

        public Builder setContent(String content) {
            this.content = content;
            return this;
        }

        public Builder setType(MessageType type) {
            this.type = type;
            return this;
        }

        public Builder setSentAt(LocalDateTime sentAt) {
            this.sentAt = sentAt;
            return this;
        }

        public Builder setDeliveredAt(LocalDateTime deliveredAt) {
            this.deliveredAt = deliveredAt;
            return this;
        }

        public Builder setSeenAt(LocalDateTime seenAt) {
            this.seenAt = seenAt;
            return this;
        }

        public Builder setSenderId(UUID userId) {
            this.senderId = userId;
            return this;
        }

        public Builder setChatId(UUID chatId) {
            this.chatId = chatId;
            return this;
        }

        public Builder setGroupId(UUID groupId) {
            this.groupId = groupId;
            return this;
        }

        public TextMessage build(){
            return new TextMessage(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextMessage that = (TextMessage) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

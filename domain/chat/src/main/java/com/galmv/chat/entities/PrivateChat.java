package com.galmv.chat.entities;

import com.galmv.message.entities.Message;
import com.galmv.user.entities.User;

import java.util.List;
import java.util.UUID;

public class PrivateChat extends Chat{

    private PrivateChat(Builder builder) {
        super(builder.participants, builder.messages);
    }

    @Override
    public UUID getId() {
        return this.id;
    }

    @Override
    public List<User> getParticipants() {
        return this.participants;
    }

    @Override
    public void addParticipants(User participant) {
        this.participants.add(participant);
    }

    @Override
    public List<Message> getMessages() {
        return this.messages;
    }

    @Override
    public void addMessages(Message message) {
        this.messages.add(message);
    }

    public static class Builder{
        private List<User> participants;
        private List<Message> messages;

        public Builder setParticipants(List<User> participants) {
            this.participants = participants;
            return this;
        }

        public Builder setMessages(List<Message> messages) {
            this.messages = messages;
            return this;
        }

        public PrivateChat build(){
            return new PrivateChat(this);
        }
    }
}

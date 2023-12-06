package com.galmv.chat.entities;

import com.galmv.message.entities.Message;
import com.galmv.user.entities.User;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public abstract class Chat {

    protected UUID id;
    protected final List<User> participants;
    protected final List<Message> messages;

    public Chat(List<User> participants, List<Message> messages) {
        this.id = UUID.randomUUID();
        this.participants = participants;
        this.messages = messages;
    }

    public abstract UUID getId();
    public abstract List<User> getParticipants();
    public abstract void addParticipants(User participant);
    public abstract List<Message> getMessages();
    public abstract void addMessages(Message message);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chat chat = (Chat) o;
        return Objects.equals(getId(), chat.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}

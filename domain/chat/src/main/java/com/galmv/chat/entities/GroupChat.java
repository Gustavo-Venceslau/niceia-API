package com.galmv.chat.entities;

import com.galmv.message.entities.Message;
import com.galmv.user.entities.User;

import java.util.List;
import java.util.UUID;

public class GroupChat extends Chat{

    private final List<User> admins;
    private String name;
    private String description;
    private String photo;
    private boolean archived;

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

    public List<User> getAdmins() {
        return admins;
    }

    public void addAdmins(User newAdmin) {
        this.admins.add(newAdmin);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public boolean isArchived() {
        return archived;
    }

    public void setArchived(boolean archived) {
        this.archived = archived;
    }

    private GroupChat(Builder builder){
        super(builder.participants, builder.messages);
        this.admins = builder.admins;
        this.name = builder.name;
        this.description = builder.description;
        this.photo = builder.photo;
        this.archived = builder.archived;
    }

    public static class Builder{
        private List<User> participants;
        private List<Message> messages;
        private List<User> admins;
        private String name;
        private String description;
        private String photo;
        private boolean archived;

        public Builder setParticipants(List<User> participants) {
            this.participants = participants;
            return this;
        }

        public Builder setMessages(List<Message> messages) {
            this.messages = messages;
            return this;
        }

        public Builder setAdmins(List<User> admins) {
            this.admins = admins;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setPhoto(String photo) {
            this.photo = photo;
            return this;
        }

        public Builder setArchived(boolean archived) {
            this.archived = archived;
            return this;
        }

        public GroupChat build(){
            return new GroupChat(this);
        }
    }
}

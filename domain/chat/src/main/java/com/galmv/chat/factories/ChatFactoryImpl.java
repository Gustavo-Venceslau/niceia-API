package com.galmv.chat.factories;

import com.galmv.chat.entities.Chat;
import com.galmv.chat.entities.GroupChat;
import com.galmv.chat.entities.PrivateChat;
import com.galmv.message.entities.Message;
import com.galmv.user.entities.User;

import java.util.List;

public class ChatFactoryImpl implements ChatFactory {
    @Override
    public GroupChat createGroupChat(
            List<User> participants,
            List<Message> messages,
            List<User> admins,
            String name,
            String description,
            String photo,
            boolean archived)
    {
        return new GroupChat.Builder()
                .setParticipants(participants)
                .setMessages(messages)
                .setAdmins(admins)
                .setName(name)
                .setDescription(description)
                .setPhoto(photo)
                .setArchived(archived)
                .build();
    }

    @Override
    public PrivateChat createPrivateChat(List<User> participants, List<Message> messages) {
        return new PrivateChat.Builder()
                .setParticipants(participants)
                .setMessages(messages)
                .build();
    }
}

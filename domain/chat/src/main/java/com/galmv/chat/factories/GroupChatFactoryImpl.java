package com.galmv.chat.factories;

import com.galmv.chat.factories.interfaces.GroupChatFactory;
import com.galmv.chat.entities.GroupChat;
import com.galmv.message.entities.Message;
import com.galmv.user.entities.User;

import java.util.List;

public class GroupChatFactoryImpl implements GroupChatFactory {

    @Override
    public GroupChat createGroupChat
            (
                    List<User> participants,
                    List<Message> messages,
                    List<User> admins,
                    String name,
                    String description,
                    String photo,
                    boolean archived
            )
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
}

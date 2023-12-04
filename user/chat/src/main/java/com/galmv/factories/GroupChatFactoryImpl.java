package com.galmv.factories;

import com.galmv.entities.GroupChat;
import com.galmv.entities.Message;
import com.galmv.entities.User;
import com.galmv.factories.interfaces.GroupChatFactory;

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

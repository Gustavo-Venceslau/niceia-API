package com.galmv.factories;

import com.galmv.entities.Message;
import com.galmv.entities.PrivateChat;
import com.galmv.entities.User;
import com.galmv.factories.interfaces.PrivateChatFactory;

import java.util.List;

public class PrivateChatFactoryImpl implements PrivateChatFactory {
    @Override
    public PrivateChat create(List<User> participants, List<Message> messages) {
        return new PrivateChat.Builder()
                .setParticipants(participants)
                .setMessages(messages)
                .build();
    }
}

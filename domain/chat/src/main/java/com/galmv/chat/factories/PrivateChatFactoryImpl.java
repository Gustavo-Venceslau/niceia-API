package com.galmv.chat.factories;

import com.galmv.message.entities.Message;
import com.galmv.chat.entities.PrivateChat;
import com.galmv.user.entities.User;
import com.galmv.chat.factories.interfaces.PrivateChatFactory;

import java.util.List;

public class PrivateChatFactoryImpl implements PrivateChatFactory {

    @Override
    public PrivateChat createPrivateChat(List<User> participants, List<Message> messages) {
        return new PrivateChat.Builder()
                .setParticipants(participants)
                .setMessages(messages)
                .build();
    }
}

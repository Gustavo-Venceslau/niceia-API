package com.galmv.factories.interfaces;

import com.galmv.entities.Message;
import com.galmv.entities.PrivateChat;
import com.galmv.entities.User;

import java.util.List;


public interface PrivateChatFactory {
    public PrivateChat create(List<User> participants, List<Message> messages);
}

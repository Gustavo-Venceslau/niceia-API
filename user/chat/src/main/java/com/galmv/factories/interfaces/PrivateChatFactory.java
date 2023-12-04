package com.galmv.factories.interfaces;

import com.galmv.entities.Chat;
import com.galmv.entities.Message;
import com.galmv.entities.User;

import java.util.List;

public interface PrivateChatFactory {
    public Chat createPrivateChat(List<User> participants, List<Message> messages);
}

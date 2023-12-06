package com.galmv.chat.factories.interfaces;

import com.galmv.chat.entities.Chat;
import com.galmv.message.entities.Message;
import com.galmv.user.entities.User;

import java.util.List;

public interface PrivateChatFactory {
    public Chat createPrivateChat(List<User> participants, List<Message> messages);
}

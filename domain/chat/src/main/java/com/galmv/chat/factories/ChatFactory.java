package com.galmv.chat.factories;

import com.galmv.chat.entities.Chat;
import com.galmv.chat.entities.GroupChat;
import com.galmv.message.entities.Message;
import com.galmv.user.entities.User;

import java.util.List;

public interface ChatFactory {
    public GroupChat createGroupChat(List<User> participants, List<Message> messages, List<User> admins, String name, String description, String photo, boolean archived);

    public Chat createPrivateChat(List<User> participants, List<Message> messages);

}

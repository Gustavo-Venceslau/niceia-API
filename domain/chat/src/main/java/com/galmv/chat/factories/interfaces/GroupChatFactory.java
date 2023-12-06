package com.galmv.chat.factories.interfaces;

import com.galmv.chat.entities.GroupChat;
import com.galmv.message.entities.Message;
import com.galmv.user.entities.User;

import java.util.List;

public interface GroupChatFactory {
    public GroupChat createGroupChat(List<User> participants, List<Message> messages, List<User> admins, String name, String description, String photo, boolean archived);
}

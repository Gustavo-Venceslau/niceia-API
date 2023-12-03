package com.galmv.factories.interfaces;

import com.galmv.entities.GroupChat;
import com.galmv.entities.Message;
import com.galmv.entities.User;

import java.util.List;

public interface GroupChatFactory {
    public GroupChat create(List<User> participants, List<Message> messages, List<User> admins, String name, String description, String photo, boolean archived);
}

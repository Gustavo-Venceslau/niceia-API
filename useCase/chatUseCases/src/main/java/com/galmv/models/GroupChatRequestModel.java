package com.galmv.models;

import com.galmv.message.entities.Message;
import com.galmv.user.entities.User;

import java.util.List;

public record GroupChatRequestModel(List<User> participants, List<Message> messages, String name, String description, String photo, boolean archived) {
}

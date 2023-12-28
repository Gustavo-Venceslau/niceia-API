package com.galmv.chat.models;

import com.galmv.message.entities.Message;
import com.galmv.user.entities.User;

import java.util.List;

public record PrivateChatRequestModel(List<User> participants, List<Message> messages) {
}

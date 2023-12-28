package com.galmv.chat.useCases.findAllMessages.model;

import com.galmv.message.entities.Message;

import java.util.List;

public record FindAllMessagesResponseModel(List<Message> messages) {}

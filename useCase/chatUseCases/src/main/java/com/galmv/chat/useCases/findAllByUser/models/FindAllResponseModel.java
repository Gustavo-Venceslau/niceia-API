package com.galmv.chat.useCases.findAllByUser.models;

import com.galmv.chat.entities.Chat;

import java.util.List;

public record FindAllResponseModel(List<Chat> chats) {}

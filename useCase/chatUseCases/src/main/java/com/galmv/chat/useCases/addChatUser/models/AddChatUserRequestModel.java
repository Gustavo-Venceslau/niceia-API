package com.galmv.chat.useCases.addChatUser.models;

import java.util.UUID;

public record AddChatUserRequestModel(UUID userId, UUID chatId){}

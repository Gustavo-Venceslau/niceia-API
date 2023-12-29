package com.galmv.chat.useCases.removeChatUser.models;

import java.util.UUID;

public record RemoveChatUserRequestModel(UUID chatId, UUID userId) {
}

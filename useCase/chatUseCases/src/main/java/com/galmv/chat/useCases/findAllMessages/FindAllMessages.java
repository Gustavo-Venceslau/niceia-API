package com.galmv.chat.useCases.findAllMessages;

import com.galmv.chat.useCases.findAllMessages.model.FindAllMessagesResponseModel;

import java.util.UUID;

public interface FindAllMessages {
    FindAllMessagesResponseModel findAllBy(UUID chatId);
}

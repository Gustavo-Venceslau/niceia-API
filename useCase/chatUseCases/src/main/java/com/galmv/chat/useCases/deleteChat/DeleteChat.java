package com.galmv.chat.useCases.deleteChat;

import java.util.UUID;

public interface DeleteChat {
    void deleteBy(UUID chatId);
}

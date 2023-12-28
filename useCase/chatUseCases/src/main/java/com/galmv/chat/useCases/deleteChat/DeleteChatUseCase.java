package com.galmv.chat.useCases.deleteChat;

import com.galmv.chat.constants.ChatErrors;
import com.galmv.chat.entities.Chat;
import com.galmv.chat.exceptions.ChatNotFoundException;
import com.galmv.chat.ports.ChatRepository;

import java.util.Optional;
import java.util.UUID;

public class DeleteChatUseCase implements DeleteChat{

    private final ChatRepository repository;

    public DeleteChatUseCase(ChatRepository repository){
        this.repository = repository;
    }

    @Override
    public void deleteBy(UUID chatId) {
        Optional<Chat> chatFound = this.repository.findById(chatId);

        if(chatFound.isEmpty()) throw new ChatNotFoundException(ChatErrors.CHAT_NOT_FOUND);

        this.repository.deleteById(chatId);
    }
}

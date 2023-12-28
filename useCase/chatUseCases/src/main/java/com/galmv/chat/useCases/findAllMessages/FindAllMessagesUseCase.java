package com.galmv.chat.useCases.findAllMessages;

import com.galmv.chat.constants.ChatErrors;
import com.galmv.chat.entities.Chat;
import com.galmv.chat.exceptions.ChatNotFoundException;
import com.galmv.chat.ports.ChatRepository;
import com.galmv.chat.useCases.findAllMessages.model.FindAllMessagesResponseModel;
import com.galmv.chat.useCases.findAllMessages.presenters.FindAllMessagesPresenter;
import com.galmv.message.entities.Message;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FindAllMessagesUseCase implements FindAllMessages{

    private final ChatRepository repository;
    private final FindAllMessagesPresenter presenter;

    public FindAllMessagesUseCase(ChatRepository repository, FindAllMessagesPresenter presenter){
        this.repository = repository;
        this.presenter = presenter;
    }

    @Override
    public FindAllMessagesResponseModel findAllBy(UUID chatId) {
        Optional<Chat> chatFound = this.repository.findById(chatId);

        if(chatFound.isEmpty()) throw new ChatNotFoundException(ChatErrors.CHAT_NOT_FOUND);

        List<Message> messages = chatFound.get().getMessages();

        return presenter.prepareView(messages);
    }
}

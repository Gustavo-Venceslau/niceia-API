package com.galmv.useCases.findByName;

import com.galmv.chat.constants.ChatErrors;
import com.galmv.chat.entities.Chat;
import com.galmv.chat.entities.GroupChat;
import com.galmv.chat.exceptions.ChatNotFoundException;
import com.galmv.models.GroupChatResponseModel;
import com.galmv.ports.ChatRepository;
import com.galmv.presenters.ChatPresenter;

import java.util.Optional;

public class FindByNameUseCase implements FindByName{

    private final ChatRepository repository;
    private final ChatPresenter presenter;

    public FindByNameUseCase(ChatRepository repository, ChatPresenter presenter){
        this.repository = repository;
        this.presenter = presenter;
    }

    @Override
    public GroupChatResponseModel findBy(String name) {
        Optional<Chat> optionalChat = this.repository.findByName(name);

        if(optionalChat.isEmpty()) throw new ChatNotFoundException(ChatErrors.CHAT_NOT_FOUND);

        return presenter.prepareGroupChatView((GroupChat) optionalChat.get());
    }
}

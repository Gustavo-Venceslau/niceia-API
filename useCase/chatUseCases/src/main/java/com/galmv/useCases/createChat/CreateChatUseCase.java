package com.galmv.useCases.createChat;

import com.galmv.chat.entities.Chat;
import com.galmv.chat.entities.GroupChat;
import com.galmv.chat.entities.PrivateChat;
import com.galmv.chat.factories.ChatFactoryImpl;
import com.galmv.models.GroupChatRequestModel;
import com.galmv.models.GroupChatResponseModel;
import com.galmv.models.PrivateChatRequestModel;
import com.galmv.models.PrivateChatResponseModel;
import com.galmv.ports.ChatRepository;
import com.galmv.presenters.ChatPresenter;

import java.util.Optional;

public class CreateChatUseCase implements CreateChat{

    private final ChatRepository repository;
    private final ChatPresenter presenter;

    public CreateChatUseCase(ChatRepository repository,ChatPresenter presenter){
        this.repository = repository;
        this.presenter = presenter;
    }

    @Override
    public PrivateChatResponseModel createPrivateChat(PrivateChatRequestModel request) {
        PrivateChat chatToCreate = new ChatFactoryImpl().createPrivateChat(request.participants(), request.messages());

        Chat response = this.repository.create(chatToCreate);

        return presenter.preparePrivateChatView((PrivateChat) response);
    }

    @Override
    public GroupChatResponseModel createGroupChat(GroupChatRequestModel request) {
        GroupChat chatToCreate = new ChatFactoryImpl().createGroupChat(
                request.participants(),
                request.messages(),
                request.admins(),
                request.name(),
                request.description(),
                request.photo(),
                request.archived()
        );

        Chat response = this.repository.create(chatToCreate);

        return presenter.prepareGroupChatView((GroupChat) response);
    }
}

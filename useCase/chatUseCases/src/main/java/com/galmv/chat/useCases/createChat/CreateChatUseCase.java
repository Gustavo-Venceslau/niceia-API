package com.galmv.chat.useCases.createChat;

import com.galmv.chat.entities.Chat;
import com.galmv.chat.entities.GroupChat;
import com.galmv.chat.entities.PrivateChat;
import com.galmv.chat.factories.ChatFactoryImpl;
import com.galmv.chat.models.GroupChatResponseModel;
import com.galmv.chat.models.GroupChatRequestModel;
import com.galmv.chat.models.PrivateChatRequestModel;
import com.galmv.chat.models.PrivateChatResponseModel;
import com.galmv.chat.ports.ChatRepository;
import com.galmv.chat.presenters.ChatPresenter;

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

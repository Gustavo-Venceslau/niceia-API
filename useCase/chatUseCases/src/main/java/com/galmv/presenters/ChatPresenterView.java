package com.galmv.presenters;

import com.galmv.chat.entities.GroupChat;
import com.galmv.chat.entities.PrivateChat;
import com.galmv.models.GroupChatResponseModel;
import com.galmv.models.PrivateChatResponseModel;

public class ChatPresenterView implements ChatPresenter{

    @Override
    public GroupChatResponseModel prepareGroupChatView(GroupChat chat) {
        return new GroupChatResponseModel(
                chat.getParticipants(),
                chat.getMessages(),
                chat.getAdmins(),
                chat.getName(),
                chat.getDescription(),
                chat.getPhoto(),
                chat.isArchived()
        );
    }

    @Override
    public PrivateChatResponseModel preparePrivateChatView(PrivateChat chat){
        return new PrivateChatResponseModel(
                chat.getParticipants(),
                chat.getMessages()
        );
    }
}

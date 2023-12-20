package com.galmv.presenters;

import com.galmv.chat.entities.GroupChat;
import com.galmv.chat.entities.PrivateChat;
import com.galmv.models.GroupChatResponseModel;
import com.galmv.models.PrivateChatResponseModel;

public interface ChatPresenter {
    GroupChatResponseModel prepareGroupChatView(GroupChat chat);
    PrivateChatResponseModel preparePrivateChatView(PrivateChat chat);
}

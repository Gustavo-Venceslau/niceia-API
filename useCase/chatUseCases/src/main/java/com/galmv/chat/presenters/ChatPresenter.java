package com.galmv.chat.presenters;

import com.galmv.chat.entities.GroupChat;
import com.galmv.chat.entities.PrivateChat;
import com.galmv.chat.models.GroupChatResponseModel;
import com.galmv.chat.models.PrivateChatResponseModel;

public interface ChatPresenter {
    GroupChatResponseModel prepareGroupChatView(GroupChat chat);
    PrivateChatResponseModel preparePrivateChatView(PrivateChat chat);
}

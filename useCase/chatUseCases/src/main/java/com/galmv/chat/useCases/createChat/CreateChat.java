package com.galmv.chat.useCases.createChat;

import com.galmv.chat.models.GroupChatResponseModel;
import com.galmv.chat.models.GroupChatRequestModel;
import com.galmv.chat.models.PrivateChatRequestModel;
import com.galmv.chat.models.PrivateChatResponseModel;

public interface CreateChat {
    PrivateChatResponseModel createPrivateChat(PrivateChatRequestModel request);

    GroupChatResponseModel createGroupChat(GroupChatRequestModel request);
}

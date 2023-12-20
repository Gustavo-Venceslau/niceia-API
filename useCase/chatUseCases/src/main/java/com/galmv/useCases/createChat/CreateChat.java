package com.galmv.useCases.createChat;

import com.galmv.models.GroupChatRequestModel;
import com.galmv.models.GroupChatResponseModel;
import com.galmv.models.PrivateChatRequestModel;
import com.galmv.models.PrivateChatResponseModel;

public interface CreateChat {
    PrivateChatResponseModel createPrivateChat(PrivateChatRequestModel request);

    GroupChatResponseModel createGroupChat(GroupChatRequestModel request);
}

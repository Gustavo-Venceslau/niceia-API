package com.galmv.useCases.updateChat;

import com.galmv.models.GroupChatRequestModel;
import com.galmv.models.GroupChatResponseModel;
import com.galmv.models.PrivateChatRequestModel;
import com.galmv.models.PrivateChatResponseModel;

import java.util.UUID;

public interface UpdateChat {

    GroupChatResponseModel updateGroupChat(UUID chatId, GroupChatRequestModel newData);
}

package com.galmv.chat.useCases.updateChat;

import com.galmv.chat.models.GroupChatResponseModel;
import com.galmv.chat.models.GroupChatRequestModel;

import java.util.UUID;

public interface UpdateChat {

    GroupChatResponseModel updateGroupChat(UUID chatId, GroupChatRequestModel newData);
}

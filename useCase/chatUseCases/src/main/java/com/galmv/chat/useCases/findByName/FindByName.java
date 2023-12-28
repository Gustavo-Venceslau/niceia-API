package com.galmv.chat.useCases.findByName;

import com.galmv.chat.models.GroupChatResponseModel;

public interface FindByName {
    GroupChatResponseModel findBy(String name);
}

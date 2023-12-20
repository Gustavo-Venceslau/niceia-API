package com.galmv.useCases.findByName;

import com.galmv.models.GroupChatResponseModel;

public interface FindByName {
    GroupChatResponseModel findBy(String name);
}

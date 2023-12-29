package com.galmv.chat.useCases.removeChatUser;

import com.galmv.chat.useCases.removeChatUser.models.RemoveChatUserRequestModel;

public interface RemoveChatUser {
    void remove(RemoveChatUserRequestModel request);
}

package com.galmv.chat.useCases.findAllByUser;

import com.galmv.chat.useCases.findAllByUser.models.FindAllRequestModel;
import com.galmv.chat.useCases.findAllByUser.models.FindAllResponseModel;

public interface FindAllByUser {

    public FindAllResponseModel find(FindAllRequestModel request);
}

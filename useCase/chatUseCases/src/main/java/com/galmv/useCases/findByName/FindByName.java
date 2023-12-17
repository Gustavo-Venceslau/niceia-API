package com.galmv.useCases.findByName;

import com.galmv.models.ChatResponseModel;

public interface FindByName {
    ChatResponseModel findBy(String name);
}

package com.galmv.chat.useCases.findAllMessages.presenters;

import com.galmv.chat.useCases.findAllMessages.model.FindAllMessagesResponseModel;
import com.galmv.message.entities.Message;

import java.util.List;

public interface FindAllMessagesPresenter {
    FindAllMessagesResponseModel prepareView(List<Message> chats);
}

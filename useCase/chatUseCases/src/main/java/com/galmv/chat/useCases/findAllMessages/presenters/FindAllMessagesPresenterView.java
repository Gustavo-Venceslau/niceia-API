package com.galmv.chat.useCases.findAllMessages.presenters;

import com.galmv.chat.useCases.findAllMessages.model.FindAllMessagesResponseModel;
import com.galmv.message.entities.Message;

import java.util.List;

public class FindAllMessagesPresenterView implements FindAllMessagesPresenter{
    @Override
    public FindAllMessagesResponseModel prepareView(List<Message> chats) {
        return new FindAllMessagesResponseModel(chats);
    }
}

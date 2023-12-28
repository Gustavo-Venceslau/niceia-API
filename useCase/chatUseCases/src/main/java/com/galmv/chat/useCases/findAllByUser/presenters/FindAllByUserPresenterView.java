package com.galmv.chat.useCases.findAllByUser.presenters;

import com.galmv.chat.entities.Chat;
import com.galmv.chat.useCases.findAllByUser.models.FindAllResponseModel;

import java.util.List;

public class FindAllByUserPresenterView implements FindAllByUserPresenter{
    @Override
    public FindAllResponseModel prepareView(List<Chat> chats) {
        return new FindAllResponseModel(chats);
    }
}

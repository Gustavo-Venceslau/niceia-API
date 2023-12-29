module chatUseCase{
    exports com.galmv.chat.useCases.findByName;
    exports com.galmv.chat.useCases.createChat;
    exports com.galmv.chat.useCases.updateChat;
    exports com.galmv.chat.useCases.deleteChat;
    exports com.galmv.chat.useCases.findAllByUser;
    exports com.galmv.chat.useCases.findAllByUser.models;
    exports com.galmv.chat.useCases.findAllByUser.presenters;
    exports com.galmv.chat.useCases.findAllMessages;
    exports com.galmv.chat.useCases.findAllMessages.model;
    exports com.galmv.chat.useCases.findAllMessages.presenters;
    exports com.galmv.chat.useCases.removeChatUser;
    exports com.galmv.chat.useCases.removeChatUser.models;
    exports com.galmv.chat.ports;
    exports com.galmv.chat.presenters;
    exports com.galmv.chat.models;

    requires galmv.domain.chat;
    requires galmv.domain.user;
    requires galmv.domain.message;
    requires useCase.userUseCase;
}
module chatUseCase{
    exports com.galmv.useCases.findByName;
    exports com.galmv.useCases.createChat;
    exports com.galmv.useCases.updateChat;
    exports com.galmv.useCases.deleteChat;
    exports com.galmv.ports;
    exports com.galmv.presenters;
    exports com.galmv.models;

    requires galmv.domain.chat;
    requires galmv.domain.user;
    requires galmv.domain.message;
}
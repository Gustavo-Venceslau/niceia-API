module galmv.domain.chat{
    exports com.galmv.chat.entities;
    exports com.galmv.chat.factories;

    requires galmv.domain.user;
    requires galmv.domain.message;
}
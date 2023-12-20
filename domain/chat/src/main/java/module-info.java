module galmv.domain.chat{
    exports com.galmv.chat.entities;
    exports com.galmv.chat.factories;
    exports com.galmv.chat.exceptions;
    exports com.galmv.chat.constants;

    requires galmv.domain.user;
    requires galmv.domain.message;
}
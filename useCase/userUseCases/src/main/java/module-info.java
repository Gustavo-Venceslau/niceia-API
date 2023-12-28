module useCase.userUseCase {
    exports com.galmv.user.useCases.findByName;
    exports com.galmv.user.useCases.createUser;
    exports com.galmv.user.useCases.updateUser;
    exports com.galmv.user.useCases.deleteUser;
    exports com.galmv.user.useCases.login;
    exports com.galmv.user.useCases.login.model;
    exports com.galmv.user.presenters;
    exports com.galmv.user.models;
    exports com.galmv.user.ports;

    requires galmv.domain.user;
}
module chatUseCasesTest {
    exports com.galmv.tests;
    exports com.galmv.config;

    requires chatUseCase;
    requires useCase.userUseCase;
    requires galmv.domain.chat;
    requires galmv.domain.message;
    requires galmv.domain.user;

    requires org.junit.jupiter.api;
    requires org.assertj.core;
}
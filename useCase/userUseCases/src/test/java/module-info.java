module useCaseUserUseCaseTest {
    requires galmv.domain.user;
    requires useCase.userUseCase;
    requires org.assertj.core;
    requires org.junit.jupiter.api;

    exports com.galmv.tests;
    exports com.galmv.utils;
    exports com.galmv.config;
}
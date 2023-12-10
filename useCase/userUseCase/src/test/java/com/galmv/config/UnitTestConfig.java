package com.galmv.config;

import com.galmv.models.UserResponseModel;
import com.galmv.ports.UserRepository;
import com.galmv.presenters.UserPresenter;
import com.galmv.presenters.UserPresenterViewer;
import com.galmv.user.entities.User;
import com.galmv.user.factories.CommonUserFactory;
import com.galmv.utils.InMemoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class UnitTestConfig {

    protected final UserRepository repository;
    protected final UserPresenter presenter;

    public UnitTestConfig(){
        this.repository = new InMemoryRepository();
        this.presenter = new UserPresenterViewer();
    }

    protected User user = new CommonUserFactory().createUser(
            "John Doe",
            "john@mail.com",
            "123",
            "12345678910",
            "happy",
            "url"
    );

    @BeforeEach
    public void before(){
        this.repository.create(user);
    }

    @AfterEach
    public void after(){
        this.repository.delete(user.getId());
    }
}

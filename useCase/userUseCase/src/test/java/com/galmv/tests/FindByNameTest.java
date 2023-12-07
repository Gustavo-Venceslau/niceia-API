package com.galmv.tests;

import com.galmv.findByName.FindByName;
import com.galmv.findByName.FindByNameImpl;
import com.galmv.models.UserRequestModel;
import com.galmv.models.UserResponseModel;
import com.galmv.repositories.InMemoryRepository;
import com.galmv.repository.UserRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class FindByNameTest {

    private final FindByName findByName;
    private final UserRepository repository;

    public FindByNameTest(){
        this.repository = new InMemoryRepository();
        this.findByName = new FindByNameImpl(repository);
    }

    @Test
    public void givenAnUser_whenFoundByName_thenUserMustBeNotNull(){
        UserRequestModel request = new UserRequestModel(
                "John Doe",
                "jhon@mail.com",
                "123",
                "12345678910",
                "happy",
                "url"
        );

        this.repository.create(request);

        UserResponseModel response = this.findByName.find(request.name());

        assertThat(response.name()).isEqualTo(request.name());
        assertThat(response.email()).isEqualTo(request.email());
        assertThat(response.password()).isEqualTo(request.password());
        assertThat(response.phone()).isEqualTo(request.phone());
        assertThat(response.status()).isEqualTo(request.status());
        assertThat(response.photo()).isEqualTo(request.photo());
    }
}

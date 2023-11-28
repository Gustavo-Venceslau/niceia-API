package com.galmv.tests.factories;

import com.galmv.entities.User;
import com.galmv.factories.CommonUserFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CommonUserFactoryTest {

    @Test
    public void givenNewCommonUserInfo_whenUserIsCreatedByFactory_thenUserInfoMustBeNotNull(){
        User user = new CommonUserFactory().createUser(
                "John Doe",
                "john@mail.com",
                "123",
                "12345678910",
                "occupied",
                "url"
        );

        assertThat(user.getId()).isNotNull();
        assertThat(user.getEmail()).isEqualTo("john@mail.com");
        assertThat(user.getPassword()).isEqualTo("123");
        assertThat(user.getPhone()).isEqualTo("12345678910");
        assertThat(user.getStatus()).isEqualTo("occupied");
        assertThat(user.getPhoto()).isEqualTo("url");
    }
}

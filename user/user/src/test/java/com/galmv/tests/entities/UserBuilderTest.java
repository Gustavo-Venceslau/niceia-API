package com.galmv.tests.entities;

import com.galmv.entities.CommonUser;
import com.galmv.entities.User;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class UserBuilderTest {

    @Test
    public void givenNewUserInformation_whenUserIsBuilt_thenUserIsNotNull(){
        User user = new CommonUser.Builder()
                .setName("John Doe")
                .setEmail("john@mail.com")
                .setPassword("123")
                .setPhone("12345678910")
                .setStatus("occupied")
                .setPhoto("url")
                .build();

        assertThat(user.getId()).isNotNull();
        assertThat(user.getEmail()).isEqualTo("john@mail.com");
        assertThat(user.getPassword()).isEqualTo("123");
        assertThat(user.getPhone()).isEqualTo("12345678910");
        assertThat(user.getStatus()).isEqualTo("occupied");
        assertThat(user.getPhoto()).isEqualTo("url");
    }
}

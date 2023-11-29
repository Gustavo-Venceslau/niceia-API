package com.galmv.tests.entities;

import com.galmv.entities.Message;
import com.galmv.entities.PrivateChat;
import com.galmv.entities.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PrivateChatBuilderTest {

    @Test
    public void givenNewPrivateChat_whenBuiltByBuilder_thenChatMustBeNotNull(){
        List<User> users = new ArrayList<>();
        List<Message> messages = new ArrayList<>();

        PrivateChat chat = new PrivateChat.Builder()
                .setParticipants(users)
                .setMessages(messages)
                .build();

        assertThat(chat.getId()).isNotNull();
        assertThat(chat.getParticipants()).isEqualTo(users);
        assertThat(chat.getMessages()).isEqualTo(messages);
    }
}

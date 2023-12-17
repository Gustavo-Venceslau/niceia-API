package com.galmv.tests.factories;

import com.galmv.chat.entities.Chat;
import com.galmv.chat.factories.ChatFactory;
import com.galmv.chat.factories.ChatFactoryImpl;
import com.galmv.message.entities.Message;
import com.galmv.user.entities.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PrivateChatFactoryImplTest {

    private final ChatFactory factory;

    public PrivateChatFactoryImplTest(){
        this.factory = new ChatFactoryImpl();
    }

    @Test
    public void givenNewPrivateChat_whenBuiltByFactory_thenPrivateChatMustNotNull(){
        List<User> participants = new ArrayList<>();
        List<Message> messages = new ArrayList<>();

        Chat chat = factory.createPrivateChat(
            participants,
            messages
        );

        assertThat(chat.getParticipants()).isEqualTo(participants);
        assertThat(chat.getMessages()).isEqualTo(messages);
    }
}

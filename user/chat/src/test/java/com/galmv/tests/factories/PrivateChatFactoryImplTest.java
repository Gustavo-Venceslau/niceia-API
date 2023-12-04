package com.galmv.tests.factories;

import com.galmv.entities.Chat;
import com.galmv.entities.Message;
import com.galmv.entities.User;
import com.galmv.factories.PrivateChatFactoryImpl;
import com.galmv.factories.interfaces.PrivateChatFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PrivateChatFactoryImplTest {

    private final PrivateChatFactory factory;

    public PrivateChatFactoryImplTest(){
        this.factory = new PrivateChatFactoryImpl();
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

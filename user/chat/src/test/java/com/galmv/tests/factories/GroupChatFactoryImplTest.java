package com.galmv.tests.factories;

import com.galmv.entities.GroupChat;
import com.galmv.entities.Message;
import com.galmv.entities.User;
import com.galmv.factories.GroupChatFactoryImpl;
import com.galmv.factories.interfaces.GroupChatFactory;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GroupChatFactoryImplTest {

    private final GroupChatFactory factory;


    public GroupChatFactoryImplTest(){
        this.factory = new GroupChatFactoryImpl();
    }

    @Test
    public void givenNewChat_whenBuiltByFactory_thenChatMustBeNotNull(){
        List<User> participants = new ArrayList<>();
        List<Message> messages = new ArrayList<>();
        List<User> admins = new ArrayList<>();

        GroupChat chat = factory.create(
                participants,
                messages,
                admins,
                "family group",
                "our family group",
                "url",
                false
        );

        assertThat(chat.getId()).isNotNull();
        assertThat(chat.getParticipants()).isEqualTo(participants);
        assertThat(chat.getMessages()).isEqualTo(messages);
        assertThat(chat.getAdmins()).isEqualTo(admins);
        assertThat(chat.getName()).isEqualTo("family group");
        assertThat(chat.getDescription()).isEqualTo("our family group");
        assertThat(chat.getPhoto()).isEqualTo("url");
        assertThat(chat.isArchived()).isFalse();
    }
}
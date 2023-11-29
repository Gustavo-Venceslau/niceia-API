package com.galmv.tests.entities;

import com.galmv.entities.GroupChat;
import com.galmv.entities.Message;
import com.galmv.entities.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GroupChatBuilderTest {

    @Test
    public void givenNewGroupChat_whenBuiltByBuilder_thenGroupMustBeNotNull(){
        List<User> participants = new ArrayList<>();
        List<Message> messages = new ArrayList<>();
        List<User> admins = new ArrayList<>();

        GroupChat chat = new GroupChat.Builder()
                .setParticipants(participants)
                .setMessages(messages)
                .setAdmins(admins)
                .setName("Party 13/01")
                .setDescription("group to party")
                .setPhoto("url")
                .setArchived(false)
                .build();

        assertThat(chat.getId()).isNotNull();
        assertThat(chat.getParticipants()).isEqualTo(participants);
        assertThat(chat.getMessages()).isEqualTo(messages);
        assertThat(chat.getAdmins()).isEqualTo(admins);
        assertThat(chat.getName()).isEqualTo("Party 13/01");
        assertThat(chat.getDescription()).isEqualTo("group to party");
        assertThat(chat.getPhoto()).isEqualTo("url");
        assertThat(chat.isArchived()).isEqualTo(false);
    }
}

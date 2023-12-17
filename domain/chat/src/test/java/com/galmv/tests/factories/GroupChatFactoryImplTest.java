package com.galmv.tests.factories;

import com.galmv.chat.entities.GroupChat;
import com.galmv.chat.factories.ChatFactory;
import com.galmv.chat.factories.ChatFactoryImpl;
import com.galmv.message.entities.Message;
import com.galmv.user.entities.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class GroupChatFactoryImplTest {

    private final ChatFactory factory = new ChatFactoryImpl();

    @Test
    public void givenNewChat_whenBuiltByFactory_thenChatMustBeNotNull(){
        List<User> participants = new ArrayList<>();
        List<Message> messages = new ArrayList<>();
        List<User> admins = new ArrayList<>();

        GroupChat chat = factory.createGroupChat(
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

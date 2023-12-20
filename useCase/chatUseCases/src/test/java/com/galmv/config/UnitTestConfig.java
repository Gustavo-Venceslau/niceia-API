package com.galmv.config;

import com.galmv.chat.entities.GroupChat;
import com.galmv.chat.entities.PrivateChat;
import com.galmv.chat.factories.ChatFactoryImpl;
import com.galmv.message.entities.Message;
import com.galmv.ports.ChatRepository;
import com.galmv.user.entities.User;
import com.galmv.utils.ChatInMemoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;
import java.util.List;

public abstract class UnitTestConfig {

    protected final ChatRepository repository;

    public UnitTestConfig(){
        this.repository = new ChatInMemoryRepository();
    }

    List<User> participants = new ArrayList<>();
    List<Message> messages = new ArrayList<>();
    List<User> admins = new ArrayList<>();
    protected GroupChat groupChat = new ChatFactoryImpl().createGroupChat(
            participants,
            messages,
            admins,
            "family group",
            "our family group",
            "url",
            false
    );

    protected PrivateChat privateChat = new ChatFactoryImpl().createPrivateChat(
            participants,
            messages
    );

    @BeforeEach
    public void before(){
        this.repository.create(groupChat);
        this.repository.create(privateChat);
    }

    @AfterEach
    public void after(){
        this.repository.deleteById(groupChat.getId());
        this.repository.deleteById(privateChat.getId());
    }
}

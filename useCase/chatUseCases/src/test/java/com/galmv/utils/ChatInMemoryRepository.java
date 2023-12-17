package com.galmv.utils;

import com.galmv.chat.entities.Chat;
import com.galmv.chat.entities.GroupChat;
import com.galmv.ports.ChatRepository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class ChatInMemoryRepository implements ChatRepository {

    private final Map<UUID, Chat> inMemoryDb = new HashMap<>();

    @Override
    public Optional<Chat> findByName(String name) {
        Optional<Chat> chatFound = inMemoryDb.values().stream()
                .filter(chat -> chat instanceof GroupChat)
                .filter(chat -> ((GroupChat) chat).getName().equals(name))
                .findAny();

        return chatFound;
    }

    @Override
    public Optional<Chat> findById(UUID chatId) {
        Optional<Chat> chatFound = inMemoryDb.values().stream()
                .filter(chat -> chat.getId().equals(chatId))
                .findAny();

        return chatFound;
    }

    @Override
    public Chat create(Chat chat) {
        inMemoryDb.put(chat.getId(), chat);

        return chat;
    }

    @Override
    public Chat update(Chat chat) {
        inMemoryDb.put(chat.getId(), chat);

        return chat;
    }

    @Override
    public void deleteById(UUID chatId) {
        inMemoryDb.remove(chatId);
    }
}

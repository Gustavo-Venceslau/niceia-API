package com.galmv.utils;

import com.galmv.chat.entities.Chat;
import com.galmv.chat.entities.GroupChat;
import com.galmv.chat.ports.ChatRepository;
import com.galmv.user.entities.User;

import java.util.*;

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
    public List<Chat> findAllByUser(UUID userId) {
        List<Chat> chats = new ArrayList<>();

        for(Chat chat: inMemoryDb.values()){
            for(User user: chat.getParticipants()){
                if(user.getId().equals(userId) && !chats.contains(chat)) chats.add(chat);
            }
        }

        return chats;
    }

    @Override
    public Chat create(Chat chat) {
        inMemoryDb.put(chat.getId(), chat);

        return chat;
    }

    @Override
    public Chat addUserToChat(UUID chatId, User user) {
        Chat chatToAdd = inMemoryDb.get(chatId);

        chatToAdd.addParticipants(user);

        inMemoryDb.put(chatId, chatToAdd);

        return chatToAdd;
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

    @Override
    public void deleteChatUserById(UUID chatId, UUID userId) {
        Chat chat = this.inMemoryDb.get(chatId);

        Optional<User> userFound = chat.getParticipants().stream().filter(user -> user.getId().equals(userId)).findAny();

        chat.getParticipants().remove(userFound.get());

        inMemoryDb.put(chatId, chat);
    }
}

package com.galmv.chat.ports;

import com.galmv.chat.entities.Chat;
import com.galmv.user.entities.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ChatRepository {

    Optional<Chat> findByName(String name);
    Optional<Chat> findById(UUID chatId);
    List<Chat> findAllByUser(UUID userId);
    Chat create(Chat chat);
    Chat addUserToChat(UUID chatId, User user);
    Chat update(Chat chat);
    void deleteById(UUID chatId);
}

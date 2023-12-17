package com.galmv.ports;

import com.galmv.chat.entities.Chat;

import java.util.Optional;
import java.util.UUID;

public interface ChatRepository {

    Optional<Chat> findByName(String name);
    Optional<Chat> findById(UUID chatId);
    Chat create(Chat chat);
    Chat update(Chat chat);
    void deleteById(UUID chatId);
}

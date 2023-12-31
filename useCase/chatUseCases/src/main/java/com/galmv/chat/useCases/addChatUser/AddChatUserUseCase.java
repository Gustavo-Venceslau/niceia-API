package com.galmv.chat.useCases.addChatUser;

import com.galmv.chat.constants.ChatErrors;
import com.galmv.chat.entities.Chat;
import com.galmv.chat.exceptions.ChatNotFoundException;
import com.galmv.chat.ports.ChatRepository;
import com.galmv.chat.useCases.addChatUser.models.AddChatUserRequestModel;
import com.galmv.user.constants.UserErrors;
import com.galmv.user.entities.User;
import com.galmv.user.exceptions.UserNotFoundException;
import com.galmv.user.ports.UserRepository;

import java.util.Optional;

public class AddChatUserUseCase implements AddChatUser{

    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    public AddChatUserUseCase(ChatRepository chatRepository, UserRepository userRepository){
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void add(AddChatUserRequestModel request) {
        Optional<User> userFound = this.userRepository.findById(request.userId());
        Optional<Chat> chatFound = this.chatRepository.findById(request.chatId());

        if(userFound.isEmpty()) throw new UserNotFoundException(UserErrors.USER_NOT_FOUND);

        if(chatFound.isEmpty()) throw new ChatNotFoundException(ChatErrors.CHAT_NOT_FOUND);

        Chat chatToAddUser = chatFound.get();

        chatToAddUser.addParticipants(userFound.get());

        this.chatRepository.addUserToChat(chatFound.get().getId(), userFound.get());
    }
}

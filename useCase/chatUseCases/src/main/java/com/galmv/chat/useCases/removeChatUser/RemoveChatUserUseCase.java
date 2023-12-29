package com.galmv.chat.useCases.removeChatUser;

import com.galmv.chat.entities.Chat;
import com.galmv.chat.exceptions.ChatNotFoundException;
import com.galmv.chat.ports.ChatRepository;
import com.galmv.chat.useCases.removeChatUser.models.RemoveChatUserRequestModel;
import com.galmv.user.constants.UserErrors;
import com.galmv.user.entities.User;
import com.galmv.user.exceptions.UserNotFoundException;
import com.galmv.user.ports.UserRepository;

import java.util.Optional;

public class RemoveChatUserUseCase implements RemoveChatUser{

    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    public RemoveChatUserUseCase(ChatRepository chatRepository, UserRepository userRepository){
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void remove(RemoveChatUserRequestModel request) {
        Optional<User> userFound = this.userRepository.findById(request.userId());
        Optional<Chat> chatFound = this.chatRepository.findById(request.chatId());

        if(userFound.isEmpty()) throw new UserNotFoundException(UserErrors.USER_NOT_FOUND);

        if(chatFound.isEmpty()) throw new ChatNotFoundException(UserErrors.USER_NOT_FOUND);

        Chat chatToRemoveUser = chatFound.get();

        this.chatRepository.deleteChatUserById(chatToRemoveUser.getId(), userFound.get().getId());
    }
}

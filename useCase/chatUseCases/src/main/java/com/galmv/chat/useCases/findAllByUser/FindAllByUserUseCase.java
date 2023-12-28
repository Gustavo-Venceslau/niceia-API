package com.galmv.chat.useCases.findAllByUser;

import com.galmv.chat.entities.Chat;
import com.galmv.chat.ports.ChatRepository;
import com.galmv.chat.useCases.findAllByUser.models.FindAllRequestModel;
import com.galmv.chat.useCases.findAllByUser.presenters.FindAllByUserPresenter;
import com.galmv.user.constants.UserErrors;
import com.galmv.user.exceptions.UserNotFoundException;
import com.galmv.user.ports.UserRepository;
import com.galmv.chat.useCases.findAllByUser.models.FindAllResponseModel;
import com.galmv.user.entities.User;

import java.util.List;
import java.util.Optional;

public class FindAllByUserUseCase implements FindAllByUser {

    private final ChatRepository chatRepository;
    private final UserRepository userRepository;

    private final FindAllByUserPresenter presenter;

    public FindAllByUserUseCase(ChatRepository chatRepository, FindAllByUserPresenter presenter, UserRepository userRepository){
        this.userRepository = userRepository;
        this.chatRepository = chatRepository;
        this.presenter = presenter;
    }

    @Override
    public FindAllResponseModel find(FindAllRequestModel request) {
        Optional<User> userFound = this.userRepository.findById(request.userId());

        if(userFound.isEmpty()) throw new UserNotFoundException(UserErrors.USER_NOT_FOUND);

        List<Chat> chats = this.chatRepository.findAllByUser(request.userId());

        return presenter.prepareView(chats);
    }
}

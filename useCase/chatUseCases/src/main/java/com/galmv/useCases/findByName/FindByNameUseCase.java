package com.galmv.useCases.findByName;

import com.galmv.models.ChatResponseModel;
import com.galmv.ports.ChatRepository;

public class FindByNameUseCase implements FindByName{

    private final ChatRepository repository;

    public FindByNameUseCase(ChatRepository repository){
        this.repository = repository;
    }

    @Override
    public ChatResponseModel findBy(String name) {
        return null;
    }
}

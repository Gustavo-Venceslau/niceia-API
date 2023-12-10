package com.galmv.presenters;

import com.galmv.models.UserResponseModel;
import com.galmv.user.entities.User;

public class UserPresenterViewer implements UserPresenter{
    public UserResponseModel prepareSuccessView(User user){
        UserResponseModel responseModel = new UserResponseModel(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getPhone(),
                user.getStatus(),
                user.getPhoto()
        );

        return responseModel;
    }
}

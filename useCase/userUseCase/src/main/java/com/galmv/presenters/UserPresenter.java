package com.galmv.presenters;

import com.galmv.models.UserResponseModel;
import com.galmv.user.entities.User;

public interface UserPresenter {

    public UserResponseModel prepareSuccessView(User user);
}

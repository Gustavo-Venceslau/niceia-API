package com.galmv.user.presenters;

import com.galmv.user.models.UserResponseModel;
import com.galmv.user.entities.User;

public interface UserPresenter {

    public UserResponseModel prepareSuccessView(User user);
}

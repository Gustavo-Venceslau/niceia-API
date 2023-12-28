package com.galmv.user.useCases.createUser;

import com.galmv.user.models.UserRequestModel;
import com.galmv.user.models.UserResponseModel;

public interface CreateUser {
    UserResponseModel create(UserRequestModel request);
}

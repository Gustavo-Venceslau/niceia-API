package com.galmv.useCases.createUser;

import com.galmv.models.UserRequestModel;
import com.galmv.models.UserResponseModel;

public interface CreateUser {
    UserResponseModel create(UserRequestModel request);
}

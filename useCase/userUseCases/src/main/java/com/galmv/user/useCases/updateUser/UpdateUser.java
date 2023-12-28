package com.galmv.user.useCases.updateUser;

import com.galmv.user.models.UserRequestModel;
import com.galmv.user.models.UserResponseModel;

import java.util.UUID;

public interface UpdateUser {
    public UserResponseModel executeWith(UUID userId, UserRequestModel newData);
}

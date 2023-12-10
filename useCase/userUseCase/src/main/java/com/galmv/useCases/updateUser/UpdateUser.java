package com.galmv.useCases.updateUser;

import com.galmv.models.UserRequestModel;
import com.galmv.models.UserResponseModel;

import java.util.UUID;

public interface UpdateUser {
    public UserResponseModel executeWith(UUID userId, UserRequestModel newData);
}

package com.galmv.user.useCases.findByName;

import com.galmv.user.models.UserResponseModel;

public interface FindByName {
    UserResponseModel findBy(String name);
}

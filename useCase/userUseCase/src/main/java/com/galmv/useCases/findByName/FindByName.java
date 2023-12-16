package com.galmv.useCases.findByName;

import com.galmv.models.UserResponseModel;

public interface FindByName {
    UserResponseModel findBy(String name);
}

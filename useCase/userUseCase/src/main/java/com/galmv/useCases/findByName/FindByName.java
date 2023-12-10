package com.galmv.useCases.findByName;

import com.galmv.models.UserResponseModel;

public interface FindByName {
    public UserResponseModel find(String name);
}

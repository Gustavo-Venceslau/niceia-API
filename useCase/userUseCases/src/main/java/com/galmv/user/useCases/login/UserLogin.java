package com.galmv.user.useCases.login;

import com.galmv.user.useCases.login.model.AuthenticationRequest;
import com.galmv.user.useCases.login.model.AuthenticationResponse;

public interface UserLogin {
    AuthenticationResponse loginBy(AuthenticationRequest credentials);
}

package com.galmv.useCases.login;

import com.galmv.useCases.login.model.AuthenticationRequest;
import com.galmv.useCases.login.model.AuthenticationResponse;

public interface UserLogin {
    AuthenticationResponse loginBy(AuthenticationRequest credentials);
}

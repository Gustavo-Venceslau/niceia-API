package com.galmv.user.ports;

import com.galmv.user.useCases.login.model.AuthenticationRequest;
import com.galmv.user.useCases.login.model.AuthenticationResponse;

public interface AuthenticationManager {
    AuthenticationResponse authenticate(AuthenticationRequest credentials);
}

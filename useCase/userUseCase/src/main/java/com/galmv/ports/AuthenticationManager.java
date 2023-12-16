package com.galmv.ports;

import com.galmv.useCases.login.model.AuthenticationRequest;
import com.galmv.useCases.login.model.AuthenticationResponse;

public interface AuthenticationManager {
    AuthenticationResponse authenticate(AuthenticationRequest credentials);
}

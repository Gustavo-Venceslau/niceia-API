package com.galmv.user.useCases.login;

import com.galmv.user.ports.AuthenticationManager;
import com.galmv.user.ports.UserRepository;
import com.galmv.user.useCases.login.model.AuthenticationRequest;
import com.galmv.user.useCases.login.model.AuthenticationResponse;
import com.galmv.user.constants.UserErrors;
import com.galmv.user.entities.User;
import com.galmv.user.exceptions.UserInvalidCredentialsException;

import java.util.Optional;

public class LoginUseCase implements UserLogin {

    private final UserRepository repository;
    private final AuthenticationManager authentication;

    public LoginUseCase(UserRepository repository, AuthenticationManager authentication){
        this.repository = repository;
        this.authentication = authentication;
    }
    @Override
    public AuthenticationResponse loginBy(AuthenticationRequest credentials) {
        Optional<User> userFound = this.repository.findByEmail(credentials.email());

        if(userFound.isEmpty()) throw new UserInvalidCredentialsException(UserErrors.USER_INVALID_CREDENTIALS);

        AuthenticationResponse token = this.authentication.authenticate(credentials);

        return token;
    }
}

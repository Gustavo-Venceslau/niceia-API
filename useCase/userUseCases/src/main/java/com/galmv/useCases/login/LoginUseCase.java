package com.galmv.useCases.login;

import com.galmv.ports.AuthenticationManager;
import com.galmv.ports.UserRepository;
import com.galmv.useCases.login.model.AuthenticationRequest;
import com.galmv.useCases.login.model.AuthenticationResponse;
import com.galmv.user.constants.Errors;
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

        if(userFound.isEmpty()) throw new UserInvalidCredentialsException(Errors.USER_INVALID_CREDENTIALS);

        AuthenticationResponse token = this.authentication.authenticate(credentials);

        return token;
    }
}

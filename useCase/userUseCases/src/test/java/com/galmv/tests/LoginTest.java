package com.galmv.tests;

import com.galmv.config.UnitTestConfig;
import com.galmv.ports.AuthenticationManager;
import com.galmv.useCases.login.LoginUseCase;
import com.galmv.useCases.login.UserLogin;
import com.galmv.useCases.login.model.AuthenticationRequest;
import com.galmv.useCases.login.model.AuthenticationResponse;
import com.galmv.user.constants.Errors;
import com.galmv.user.exceptions.UserInvalidCredentialsException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LoginTest extends UnitTestConfig {

    private final UserLogin login;
    private final AuthenticationManager authentication;

    public LoginTest(){
        this.authentication = new AuthenticationManager() {
            @Override
            public AuthenticationResponse authenticate(AuthenticationRequest credentials) {
                if(credentials.email().equals(user.getEmail()) && credentials.password().equals(user.getPassword())){
                    return new AuthenticationResponse("correct");
                }
                throw new UserInvalidCredentialsException(Errors.USER_INVALID_CREDENTIALS);
            }
        };
        this.login = new LoginUseCase(repository, authentication);
    }

    @Test
    public void givenAnUserEmailAndPassword_whenUserIsValid_thenUserMustBeAuthenticated(){
        AuthenticationRequest request = new AuthenticationRequest("john@mail.com", "123");

        AuthenticationResponse response = login.loginBy(request);

        assertThat(response.token()).isNotNull();
    }

    @Test
    public void givenInvalidEmail_whenUserLogin_thenUserMustBeForbidden(){
        AuthenticationRequest request = new AuthenticationRequest("joh@mail.com", "123");

        assertThatExceptionOfType(UserInvalidCredentialsException.class).isThrownBy(() ->
                login.loginBy(request)).withMessage(Errors.USER_INVALID_CREDENTIALS);
    }

    @Test
    public void givenInvalidPassword_whenUserLogin_thenUserMustBeForbidden(){
        AuthenticationRequest request = new AuthenticationRequest("john@mail.com", "1234");

        assertThatExceptionOfType(UserInvalidCredentialsException.class).isThrownBy(() ->
                login.loginBy(request)).withMessage(Errors.USER_INVALID_CREDENTIALS);
    }
}

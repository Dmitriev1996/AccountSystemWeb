package ru.project.accountsystem.services;

import ru.project.accountsystem.dto.TokenDTO;
import ru.project.accountsystem.entities.User;

import java.util.Optional;

/**
 * Created by Admin on 05.05.2019.
 */
public interface UserAuthenticationService {

    Optional<TokenDTO> login(String username, String password);
    Optional<TokenDTO> registration(User user);
    Optional<User> findByToken(String token);
    void logout(User user);
}

package ru.project.accountsystem.services.impl;

import com.google.common.collect.ImmutableMap;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import ru.project.accountsystem.dao.UserDAO;
import ru.project.accountsystem.dto.TokenDTO;
import ru.project.accountsystem.entities.User;
import ru.project.accountsystem.services.TokenService;
import ru.project.accountsystem.services.UserAuthenticationService;
import ru.project.accountsystem.services.UserService;

import java.util.Objects;
import java.util.Optional;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

/**
 * Created by Admin on 05.05.2019.
 */
@Service
@AllArgsConstructor(access = PACKAGE)
@FieldDefaults(level = PRIVATE, makeFinal = true)
public class TokenAuthenticationService implements UserAuthenticationService {

    @NonNull
    TokenService tokenService;
    @NonNull
    UserService userService;

    @Override
    public Optional<TokenDTO> login(String username, String password) {
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setToken(userService
                .findByUsername(username)
                .filter(user -> Objects.equals(password, user.getPassword()))
                .map(user -> tokenService.expiring(ImmutableMap.of("username", username)))
                .orElse(""));
        return Optional.ofNullable(tokenDTO);
    }

    @Override
    public Optional<TokenDTO> registration(User user) {
        try {
            User regUser = userService.createNewUser(user);
            return login(regUser.getUsername(), regUser.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<User> findByToken(String token) {
        return Optional
                .of(tokenService.verify(token))
                .map(map -> map.get("username"))
                .flatMap(userService::findByUsername);
    }

    @Override
    public void logout(User user) {

    }
}

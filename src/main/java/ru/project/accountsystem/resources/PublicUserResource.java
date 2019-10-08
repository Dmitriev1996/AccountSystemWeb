package ru.project.accountsystem.resources;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.accountsystem.dto.CredentialsDTO;
import ru.project.accountsystem.dto.TokenDTO;
import ru.project.accountsystem.entities.User;
import ru.project.accountsystem.services.UserAuthenticationService;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

/**
 * Created by Admin on 05.05.2019.
 */
@RestController
@RequestMapping("/api/public/users")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
public class PublicUserResource {

    @NonNull
    private UserAuthenticationService authenticationService;

    @PostMapping("/registration")
    public TokenDTO registration(@RequestBody User user) {
        return authenticationService.registration(user)
                .orElseThrow(() -> new RuntimeException("invalid login and/or password"));
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/login", produces = "application/json", consumes = "application/json")
    public TokenDTO login(@RequestBody CredentialsDTO user) {
        return authenticationService.login(user.getLogin(), user.getPassword())
                .orElseThrow(() -> new RuntimeException("invalid login and/or password"));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/greeting")
    public String helloWorld() {
        return "Hello World!";
    }

}

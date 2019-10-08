package ru.project.accountsystem.resources;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.accountsystem.dto.ProfileDTO;
import ru.project.accountsystem.entities.User;
import ru.project.accountsystem.services.UserService;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

/**
 * Created by Admin on 13.05.2019.
 */
@RestController
@RequestMapping("/api/users")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
public class UserResource {

    @NonNull
    private UserService userService;

    @CrossOrigin(origins = "*")
    @GetMapping("/getUserByUsername/{username}")
    public ProfileDTO getProfileByUsername(@PathVariable("username") String username) {
        return userService.getProfileByUsername(username);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/updateUserByUsername")
    public int updateProfileByUsername(@RequestBody ProfileDTO profileDTO) {
        return userService.updateProfileByUsername(profileDTO);
    }
}

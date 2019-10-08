package ru.project.accountsystem.services;

import ru.project.accountsystem.dto.ProfileDTO;
import ru.project.accountsystem.entities.User;

import java.util.Optional;

/**
 * Created by Admin on 04.05.2019.
 */
public interface UserService {
    ProfileDTO getProfileByUsername(String username);

    User save(User user);

    Optional<User> find(Long id);

    Optional<User> findByUsername(String username);

    int updateProfileByUsername(ProfileDTO profileDTO);

    User createNewUser(User user);
}

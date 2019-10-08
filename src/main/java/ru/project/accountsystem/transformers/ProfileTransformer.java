package ru.project.accountsystem.transformers;

import org.springframework.stereotype.Component;
import ru.project.accountsystem.dto.ProfileDTO;
import ru.project.accountsystem.entities.User;

/**
 * Created by Admin on 13.05.2019.
 */
@Component
public class ProfileTransformer {

    public ProfileTransformer(){}

    public ProfileDTO transformUserToProfileDTO(User user) {
        ProfileDTO profileDTO = new ProfileDTO();
        profileDTO.setUserId(user.getId());
        profileDTO.setSurname(user.getSurname());
        profileDTO.setName(user.getName());
        profileDTO.setPatronymic(user.getPatronymic());
        profileDTO.setPosition(user.getPosition().getName());
        profileDTO.setKpiList(user.getKPIList());
        profileDTO.setUsername(user.getLogin());

        return profileDTO;
    }
}

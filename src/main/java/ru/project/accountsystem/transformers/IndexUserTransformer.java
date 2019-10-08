package ru.project.accountsystem.transformers;

import org.springframework.stereotype.Component;
import ru.project.accountsystem.dto.WorkerDTO;
import ru.project.accountsystem.entities.IndexUser;
import ru.project.accountsystem.entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 14.05.2019.
 */
@Component
public class IndexUserTransformer {

    public IndexUserTransformer(){};

    public List<WorkerDTO> transformIndexUserListToWorkerDTOList(List<IndexUser> indexUserList) {
        ArrayList<WorkerDTO> workerDTOList = new ArrayList<>();
        WorkerDTO workerDTO;
        User user;

        for(IndexUser indexUser : indexUserList) {
            workerDTO = new WorkerDTO();
            user = indexUser.getUser();
            workerDTO.setUserId(user.getId());
            workerDTO.setSurname(user.getSurname());
            workerDTO.setName(user.getName());
            workerDTO.setPatronymic(user.getPatronymic());
            workerDTO.setPosition(user.getPosition());
            workerDTO.setUsername(user.getLogin());
            workerDTO.setEfficiency(indexUser.getEfficiency());
            workerDTO.setCoefficientPremium(indexUser.getCoefficientPremium());
            workerDTO.setRate(indexUser.getRate());
            workerDTO.setDate(indexUser.getDate());
            workerDTOList.add(workerDTO);
        }

        return workerDTOList;

    }
}

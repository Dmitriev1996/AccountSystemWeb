package ru.project.accountsystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.project.accountsystem.dao.IndexWorkerDAO;
import ru.project.accountsystem.dto.IndexWorkerFindDTO;
import ru.project.accountsystem.dto.WorkerDTO;
import ru.project.accountsystem.services.IndexWorkerService;
import ru.project.accountsystem.transformers.IndexUserTransformer;

import java.util.List;

/**
 * Created by Admin on 14.05.2019.
 */
@Service
public class IndexWorkerServiceImpl implements IndexWorkerService {

    @Autowired
    private IndexWorkerDAO indexWorkerDAO;

    @Autowired
    private IndexUserTransformer indexUserTransformer;

    @Override
    public List<WorkerDTO> findIndexUserByDate(IndexWorkerFindDTO dto) {
        return indexUserTransformer
                .transformIndexUserListToWorkerDTOList(indexWorkerDAO
                        .findIndexUserByDate(dto.getDateBegin(), dto.getDateEnd()));
    }
}

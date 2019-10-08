package ru.project.accountsystem.services;

import ru.project.accountsystem.dto.IndexWorkerFindDTO;
import ru.project.accountsystem.dto.WorkerDTO;

import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 14.05.2019.
 */
public interface IndexWorkerService {
    List<WorkerDTO> findIndexUserByDate(IndexWorkerFindDTO dto);
}

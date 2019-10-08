package ru.project.accountsystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.project.accountsystem.dao.KPIDAO;
import ru.project.accountsystem.dto.KpiDTO;
import ru.project.accountsystem.entities.KPI;
import ru.project.accountsystem.services.KPIService;

import java.util.List;

/**
 * Created by Admin on 12.05.2019.
 */
@Service
public class KPIServiceImpl implements KPIService {

    @Autowired
    private KPIDAO kpiDAO;

    @Override
    public List<KPI> getKPIByUsername(KpiDTO kpiDTO) {

        return kpiDAO.findKPIByUsername(kpiDTO.getUsername(),
                kpiDTO.getDateBegin(),
                kpiDTO.getDateEnd());
    }
}

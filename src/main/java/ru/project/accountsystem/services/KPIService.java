package ru.project.accountsystem.services;

import ru.project.accountsystem.dto.KpiDTO;
import ru.project.accountsystem.entities.KPI;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Admin on 12.05.2019.
 */
public interface KPIService {
    List<KPI> getKPIByUsername(KpiDTO kpiDTO);
}

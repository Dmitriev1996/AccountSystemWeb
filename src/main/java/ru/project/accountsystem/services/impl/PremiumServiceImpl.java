package ru.project.accountsystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.project.accountsystem.dao.CoefficientDAO;
import ru.project.accountsystem.dao.KPIDAO;
import ru.project.accountsystem.entities.Coefficient;
import ru.project.accountsystem.entities.KPI;
import ru.project.accountsystem.services.PremiumService;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 24.05.2019.
 */
@Service
public class PremiumServiceImpl implements PremiumService {

    @Autowired
    private CoefficientDAO coefficientDAO;

    @Autowired
    private KPIDAO kpidao;



    @Override
    public BigDecimal defineCoefficientPremium(BigDecimal index) {
        List<Coefficient> coefficientList = coefficientDAO.findAll();
        for (Coefficient coefficient : coefficientList) {
            if (index.compareTo(coefficient.getLowerLimit()) >= 0
                    && index.compareTo(coefficient.getUpperLimit()) <= 0) {
                return coefficient.getValue();
            }
        }

        return BigDecimal.ZERO;
    }

    @Override
    public void recalcEfficiencyAndIndex(Date dateBegin, Date dateEnd, String username) {
        BigDecimal efficiency = BigDecimal.ZERO;
        BigDecimal index;
        List<KPI> kpiList = kpidao.findKPIByUsername(username, dateBegin, dateEnd);
        for (KPI kpi : kpiList) {
            index = kpi.getTypeKPI().getWeight().multiply(kpi.getValue()).divide(kpi.getTypeKPI().getPurpose());
            efficiency.add(index);
        }
        defineCoefficientPremium(efficiency);
        //findIndexUserByUsernameAndDate
        //updateIndexUser
    }
}

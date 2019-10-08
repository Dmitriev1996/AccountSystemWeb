package ru.project.accountsystem.services;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Admin on 24.05.2019.
 */
public interface PremiumService {
    BigDecimal defineCoefficientPremium(BigDecimal index);
    void recalcEfficiencyAndIndex(Date dateBegin, Date dateEnd, String username);
}

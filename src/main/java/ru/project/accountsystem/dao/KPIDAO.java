package ru.project.accountsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.project.accountsystem.entities.KPI;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 04.05.2019.
 */
public interface KPIDAO extends JpaRepository<KPI, Long> {
    @Query("select kpi from KPI kpi where kpi.user.login = :username " +
            "and kpi.date >= :dateBegin and kpi.date <= :dateEnd")
    List<KPI> findKPIByUsername(@Param("username") String username,
                                @Param("dateBegin") Date dateBegin,
                                @Param("dateEnd") Date dateEnd);
}

package ru.project.accountsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.project.accountsystem.entities.IndexUser;

import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 04.05.2019.
 */
public interface IndexWorkerDAO extends JpaRepository<IndexUser, Long> {
    @Query("select indexUser from IndexUser indexUser " +
            "where indexUser.date >= :dateBegin and indexUser.date <= :dateEnd")
    List<IndexUser> findIndexUserByDate(@Param("dateBegin") Date dateBegin,
                                        @Param("dateEnd") Date dateEnd);
}

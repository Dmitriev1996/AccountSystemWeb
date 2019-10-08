package ru.project.accountsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.project.accountsystem.entities.Coefficient;

/**
 * Created by Admin on 24.05.2019.
 */
public interface CoefficientDAO extends JpaRepository<Coefficient, Long> {
}

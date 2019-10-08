package ru.project.accountsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.project.accountsystem.entities.User;

/**
 * Created by Admin on 04.05.2019.
 */
public interface WorkerDAO extends JpaRepository<User, Long> {
}

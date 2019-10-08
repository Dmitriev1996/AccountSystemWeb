package ru.project.accountsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.project.accountsystem.entities.User;


/**
 * Created by Admin on 04.05.2019.
 */
public interface UserDAO extends JpaRepository<User, Long> {

    @Query("select user from User user where user.login = :username")
    User findByUsername(@Param("username") String username);

    @Modifying
    @Transactional
    @Query("update User user set user.surname = :surname, " +
            "user.name = :name, user.patronymic = :patronymic, " +
            "user.position = :position where user.login = :username")
    int updateUserByUsername(@Param("username") String username,
                              @Param("surname") String surname,
                              @Param("name") String name,
                              @Param("patronymic") String patronymic,
                              @Param("position") String position);
}

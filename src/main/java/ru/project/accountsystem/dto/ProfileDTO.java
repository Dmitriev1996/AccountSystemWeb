package ru.project.accountsystem.dto;

import lombok.Getter;
import lombok.Setter;
import ru.project.accountsystem.entities.KPI;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Admin on 13.05.2019.
 */
@Getter
@Setter
public class ProfileDTO implements Serializable {

    public ProfileDTO(){}

    private Long userId;
    private String surname;
    private String name;
    private String patronymic;
    private String position;
    private List<KPI> kpiList;
    private String username;
}

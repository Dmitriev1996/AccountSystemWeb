package ru.project.accountsystem.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Admin on 14.05.2019.
 */
@Getter
@Setter
public class WorkerDTO implements Serializable {

    public WorkerDTO(){}

    private Long userId;
    private String surname;
    private String name;
    private String patronymic;
    private String position;
    private BigDecimal efficiency;
    private BigDecimal coefficientPremium;
    private Long rate;
    private String username;
    private Date date;
}

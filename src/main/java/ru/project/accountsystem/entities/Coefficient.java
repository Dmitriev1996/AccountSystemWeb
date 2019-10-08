package ru.project.accountsystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Admin on 24.05.2019.
 */
@Getter
@Setter
@Entity
public class Coefficient implements Serializable {

    public Coefficient(){};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name="LOWER_LIMIT")
    private BigDecimal lowerLimit;
    @Column(name="UPPER_LIMIT")
    private BigDecimal upperLimit;
    @Column(name="VALUE")
    private BigDecimal value;
}

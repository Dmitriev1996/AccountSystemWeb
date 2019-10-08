package ru.project.accountsystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Admin on 04.05.2019.
 */
@Entity
@Table(name = "statements")
@Getter
@Setter
public class Statement implements Serializable {

    public Statement() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @Column(name = "DATE")
    private Date date;
    @Column(name = "PREMIUM")
    private BigDecimal premium;
    @Column(name = "FINAL_SALARY")
    private BigDecimal finalSalary;

}

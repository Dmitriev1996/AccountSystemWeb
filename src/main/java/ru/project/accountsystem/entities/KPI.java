package ru.project.accountsystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 04.05.2019.
 */
@Entity
@Table(name = "kpies")
@Getter
@Setter
public class KPI implements Serializable {

    public KPI() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @OneToOne
    @JoinColumn(name = "TYPE_KPI_ID")
    private TypeKPI typeKPI;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User user;
    @Column(name = "DATE")
    private Date date;
    @Column(name = "VALUE")
    private BigDecimal value;



}

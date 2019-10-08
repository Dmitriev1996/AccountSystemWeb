package ru.project.accountsystem.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Admin on 23.05.2019.
 */
@Entity
@Table(name = "positions")
@Getter
@Setter
public class Position {

    public Position(){};

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "ID")
    private Long id;
    @Column(name="NAME")
    private String name;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "positions_kpies",
            joinColumns = @JoinColumn(name = "POSITION_ID"),
            inverseJoinColumns = @JoinColumn(name = "TYPE_KPI_ID"))
    private List<TypeKPI> typeKPIS;

}

package ru.project.accountsystem.services;

import ru.project.accountsystem.entities.TypeKPI;

import java.util.List;

/**
 * Created by Admin on 15.05.2019.
 */
public interface TypeKPIService {
    List<TypeKPI> findAllTypeKPI();
}

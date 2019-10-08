package ru.project.accountsystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.project.accountsystem.dao.TypeKPIDAO;
import ru.project.accountsystem.entities.TypeKPI;
import ru.project.accountsystem.services.TypeKPIService;

import java.util.List;

/**
 * Created by Admin on 15.05.2019.
 */
@Service
public class TypeKPIServiceImpl implements TypeKPIService {

    @Autowired
    private TypeKPIDAO typeKPIDAO;

    @Override
    public List<TypeKPI> findAllTypeKPI() {
        return typeKPIDAO.findAll();
    }
}

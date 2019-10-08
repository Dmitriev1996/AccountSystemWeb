package ru.project.accountsystem.services.impl;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.project.accountsystem.dao.CoefficientDAO;
import ru.project.accountsystem.dao.UserDAO;
import ru.project.accountsystem.dto.ProfileDTO;
import ru.project.accountsystem.entities.*;
import ru.project.accountsystem.services.PremiumService;
import ru.project.accountsystem.services.UserService;
import ru.project.accountsystem.transformers.ProfileTransformer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by Admin on 04.05.2019.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private CoefficientDAO coefficientDAO;

    @Autowired
    private ProfileTransformer profileTransformer;

    @NonNull
    private PremiumService premiumService;

    @Override
    public ProfileDTO getProfileByUsername(String username) {
        return profileTransformer.transformUserToProfileDTO(userDAO.findByUsername(username));
    }

    @Override
    public User save(User user) {
        return userDAO.save(user);
    }

    @Override
    public Optional<User> find(Long id) {
        return userDAO.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return Optional.of(userDAO.findByUsername(username));
    }

    @Override
    public int updateProfileByUsername(ProfileDTO profileDTO) {
        return userDAO.updateUserByUsername(profileDTO.getUsername(),
                                            profileDTO.getSurname(),
                                            profileDTO.getName(),
                                            profileDTO.getPatronymic(),
                                            profileDTO.getPosition());
    }

    @Override
    public User createNewUser(User user) {
        List<KPI> kpiList = new ArrayList<>();
        List<IndexUser> indexUserList = new ArrayList<>();
        KPI kpi;
        BigDecimal efficiency = BigDecimal.ZERO;
        BigDecimal index;
        Date date = new Date();
            for (TypeKPI typeKPI : user.getPosition().getTypeKPIS()) {
                kpi = new KPI();
                kpi.setTypeKPI(typeKPI);
                kpi.setDate(date);
                kpi.setValue(BigDecimal.ZERO);
                kpiList.add(kpi);
                index = typeKPI.getWeight().multiply(kpi.getValue()).divide(typeKPI.getPurpose());
                efficiency.add(index);
            }
            user.setKPIList(kpiList);
            IndexUser indexUser = new IndexUser();
            indexUser.setDate(date);
            indexUser.setEfficiency(efficiency);
            indexUser.setCoefficientPremium(premiumService.defineCoefficientPremium(efficiency));
            indexUserList.add(indexUser);
            user.setIndexUserList(indexUserList);
            return userDAO.save(user);
    }
}

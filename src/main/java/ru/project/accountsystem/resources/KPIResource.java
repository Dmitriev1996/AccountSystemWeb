package ru.project.accountsystem.resources;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.accountsystem.dto.CredentialsDTO;
import ru.project.accountsystem.dto.KpiDTO;
import ru.project.accountsystem.entities.KPI;
import ru.project.accountsystem.services.KPIService;

import java.util.List;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

/**
 * Created by Admin on 12.05.2019.
 */
@RestController
@RequestMapping("/api/users")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
public class KPIResource {

    @NonNull
    private KPIService kpiService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/getKPIByUsername")
    public List<KPI> getKPIByUsername(@RequestBody KpiDTO kpiDTO) {
        return kpiService.getKPIByUsername(kpiDTO);
    }
}

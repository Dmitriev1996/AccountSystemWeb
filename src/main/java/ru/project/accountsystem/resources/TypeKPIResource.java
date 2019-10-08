package ru.project.accountsystem.resources;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.project.accountsystem.entities.TypeKPI;
import ru.project.accountsystem.services.TypeKPIService;

import java.util.List;

import static lombok.AccessLevel.PACKAGE;
import static lombok.AccessLevel.PRIVATE;

/**
 * Created by Admin on 15.05.2019.
 */
@RestController
@RequestMapping("/api/users")
@FieldDefaults(level = PRIVATE, makeFinal = true)
@AllArgsConstructor(access = PACKAGE)
public class TypeKPIResource {

    @NonNull
    private TypeKPIService typeKPIService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getAllTypeKPI")
    public List<TypeKPI> getAllTypeKPI() {
        return typeKPIService.findAllTypeKPI();
    }

}

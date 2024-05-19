package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.ClassRegistration;
import vn.edu.iuh.fit.repositories.ClassRegistrationRepository;
import vn.edu.iuh.fit.services.ClassRegistrationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/class-registrations")
@CrossOrigin(origins = "*")
public class ClassRegistrationController {
    @Autowired
    private ClassRegistrationService classRegistrationService;
    @Autowired
    private ClassRegistrationRepository classRegistrationRepository;

    @GetMapping
    public List<ClassRegistration> findAll() {
        return classRegistrationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ClassRegistration findById(@PathVariable("id") long id) {
        Optional<ClassRegistration> classRegistration = classRegistrationRepository.findById(id);
        return classRegistration.orElse(null);
    }

    @PutMapping
    public ClassRegistration update(@RequestBody ClassRegistration classRegistration) {
        return classRegistrationRepository.save(classRegistration);
    }
}

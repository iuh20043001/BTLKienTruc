package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.ClassRegistration;
import vn.edu.iuh.fit.repositories.ClassRegistrationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClassRegistrationService {
    @Autowired
    private ClassRegistrationRepository classRegistrationRepository;

    public Optional<ClassRegistration> findById(Long id) {
        return classRegistrationRepository.findById(id);
    }

    public ClassRegistration save(ClassRegistration classRegistration) {
        return classRegistrationRepository.save(classRegistration);
    }

    public void deleteById(Long id) {
        classRegistrationRepository.deleteById(id);
    }

    public List<ClassRegistration> findAll() {
        return classRegistrationRepository.findAll();
    }
}

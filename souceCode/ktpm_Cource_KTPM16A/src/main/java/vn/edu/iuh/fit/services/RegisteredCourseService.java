package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.RegisteredCourse;
import vn.edu.iuh.fit.repositories.RegisteredCourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RegisteredCourseService {
    @Autowired
    private RegisteredCourseRepository registeredCourseRepository;

    public Optional<RegisteredCourse> findById(Long id) {
        return registeredCourseRepository.findById(id);
    }

    public RegisteredCourse save(RegisteredCourse registeredCourse) {
        return registeredCourseRepository.save(registeredCourse);
    }

    public void deleteById(Long id) {
        registeredCourseRepository.deleteById(id);
    }

    public List<RegisteredCourse> findAll() {
        return registeredCourseRepository.findAll();
    }
}

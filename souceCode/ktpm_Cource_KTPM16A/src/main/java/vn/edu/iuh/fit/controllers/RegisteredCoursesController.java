package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.RegisteredCourse;
import vn.edu.iuh.fit.repositories.RegisteredCourseRepository;
import vn.edu.iuh.fit.services.RegisteredCourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/registered-courses")
@CrossOrigin(origins = "*")
public class RegisteredCoursesController {
    @Autowired
    private RegisteredCourseService registeredCourseService;
    @Autowired
    private RegisteredCourseRepository registeredCourseRepository;

    @GetMapping
    public List<RegisteredCourse> findAll() {
        return registeredCourseRepository.findAll();
    }

    @GetMapping("/{id}")
    public RegisteredCourse findById(@PathVariable("id") long id) {
        Optional<RegisteredCourse> registeredCourse = registeredCourseRepository.findById(id);
        return registeredCourse.orElse(null);
    }

    @PutMapping
    public RegisteredCourse update(@RequestBody RegisteredCourse registeredCourse) {
        return registeredCourseRepository.save(registeredCourse);
    }

    @PostMapping
    public RegisteredCourse create(@RequestBody RegisteredCourse registeredCourse) {
        return registeredCourseRepository.save(registeredCourse);
    }
}

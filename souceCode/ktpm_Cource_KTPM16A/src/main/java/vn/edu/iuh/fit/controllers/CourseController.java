package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.Course;
import vn.edu.iuh.fit.repositories.CourseRepository;
import vn.edu.iuh.fit.services.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/courses")
@CrossOrigin(origins = "*")
public class CourseController {
    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @GetMapping("/{id}")
    public Course findById(@PathVariable("id") long id) {
        Optional<Course> course = courseRepository.findById(id);
        return course.orElse(null);
    }

    @PutMapping
    public Course update(@RequestBody Course course) {
        return courseRepository.save(course);
    }
}

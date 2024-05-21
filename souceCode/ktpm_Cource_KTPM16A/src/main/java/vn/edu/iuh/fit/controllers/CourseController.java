package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.ClassRegistration;
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

    @GetMapping("/{courseId}/class-registrations/count")
    public ResponseEntity<Integer> getClassRegistrationCountByCourseId(@PathVariable Long courseId) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            int classRegistrationCount = course.getClassRegistrations().size();
            return ResponseEntity.ok(classRegistrationCount);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{courseId}/class-registrations")
    public ResponseEntity<List<ClassRegistration>> getClassRegistrationsByCourseId(@PathVariable Long courseId) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if (courseOptional.isPresent()) {
            Course course = courseOptional.get();
            List<ClassRegistration> classRegistrations = course.getClassRegistrations();
            return ResponseEntity.ok(classRegistrations);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.entity.ResponsePages;
import vn.edu.iuh.fit.models.Course;
import vn.edu.iuh.fit.services.CourseService;

@RestController
@RequestMapping("/course")
@CrossOrigin(origins = "*")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public boolean create(@RequestBody Course course) {
        return courseService.create(course) != null;
    }

    @PutMapping
    public boolean update(@RequestBody Course course) {
        return courseService.update(course) != null;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        courseService.delete(id);
        return true;
    }

    @GetMapping("/{id}")
    public Course getById(@PathVariable long id) {
        return courseService.getById(id);
    }

    @GetMapping("get-page/{page}")
    public ResponseEntity<ResponsePages> getAll(@PathVariable int page) {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getAll(Pageable.ofSize(10).withPage(page)));
    }
}

package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.entity.ResponsePages;
import vn.edu.iuh.fit.models.Enrollment;
import vn.edu.iuh.fit.services.EnrollmentService;

@RestController
@RequestMapping("/enrollment")
@CrossOrigin(origins = "*")
public class EnrollmentController {
    @Autowired
    private EnrollmentService enrollmentService;

    @PostMapping
    public boolean create(@RequestBody Enrollment enrollment) {
        return enrollmentService.create(enrollment) != null;
    }

    @PutMapping
    public boolean update(@RequestBody Enrollment enrollment) {
        return enrollmentService.update(enrollment) != null;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        enrollmentService.delete(id);
        return true;
    }

    @GetMapping("/{id}")
    public Enrollment getById(@PathVariable long id) {
        return enrollmentService.getById(id);
    }

    @GetMapping("get-page/{page}")
    public ResponseEntity<ResponsePages> getAll(@PathVariable int page) {
        return ResponseEntity.status(HttpStatus.OK).body(enrollmentService.getAll(Pageable.ofSize(4).withPage(page)));
    }
}

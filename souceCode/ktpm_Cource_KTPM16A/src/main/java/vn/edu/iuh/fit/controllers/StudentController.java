package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.entity.ResponsePages;
import vn.edu.iuh.fit.models.Student;
import vn.edu.iuh.fit.services.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "*")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping
    public boolean create(@RequestBody Student student) {
        return studentService.create(student) != null;
    }

    @PutMapping
    public boolean update(@RequestBody Student student) {
        return studentService.update(student) != null;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        studentService.delete(id);
        return true;
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable long id) {
        return studentService.getById(id);
    }

    @GetMapping("get-page/{page}")
    public ResponseEntity<ResponsePages> getAll(@PathVariable int page) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAll(Pageable.ofSize(4).withPage(page)));
    }
}

package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.Student;
import vn.edu.iuh.fit.repositories.StudentRepository;
import vn.edu.iuh.fit.services.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/students")
@CrossOrigin(origins = "*")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable("id") long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student) {
        try {
            Student newStudent = studentRepository.save(student);
            return ResponseEntity.ok(newStudent);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public Student update(@RequestBody Student student) {
        return studentRepository.save(student);
    }
}

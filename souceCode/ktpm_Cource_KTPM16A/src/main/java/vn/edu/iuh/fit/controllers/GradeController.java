package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.entity.ResponsePages;
import vn.edu.iuh.fit.models.Grade;
import vn.edu.iuh.fit.services.GradeService;

@RestController
@RequestMapping("/grade")
@CrossOrigin(origins = "*")
public class GradeController {
    @Autowired
    private GradeService gradeService;

    @PostMapping
    public boolean create(@RequestBody Grade grade) {
        return gradeService.create(grade) != null;
    }

    @PutMapping
    public boolean update(@RequestBody Grade grade) {
        return gradeService.update(grade) != null;
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable long id) {
        gradeService.delete(id);
        return true;
    }

    @GetMapping("/{id}")
    public Grade getById(@PathVariable long id) {
        return gradeService.getById(id);
    }

    @GetMapping("get-page/{page}")
    public ResponseEntity<ResponsePages> getAll(@PathVariable int page) {
        return ResponseEntity.status(HttpStatus.OK).body(gradeService.getAll(Pageable.ofSize(4).withPage(page)));
    }
}

package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.Major;
import vn.edu.iuh.fit.repositories.MajorRepository;
import vn.edu.iuh.fit.services.MajorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/majors")
@CrossOrigin(origins = "*")
public class MajorController {
    @Autowired
    private MajorService majorService;
    @Autowired
    private MajorRepository majorRepository;

    @GetMapping
    public List<Major> findAll() {
        return majorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Major findById(@PathVariable("id") long id) {
        Optional<Major> major = majorRepository.findById(id);
        return major.orElse(null);
    }

    @PostMapping
    public ResponseEntity<Major> create(@RequestBody Major major) {
        try {
            Major newMajor = majorRepository.save(major);
            return ResponseEntity.ok(newMajor);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping
    public Major update(@RequestBody Major major) {
        return majorRepository.save(major);
    }
}

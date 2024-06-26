package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.ClassDetails;
import vn.edu.iuh.fit.repositories.ClassDetailsRepository;
import vn.edu.iuh.fit.services.ClassDetailsService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/class-details")
@CrossOrigin(origins = "*")
public class ClassDetailsController {
    @Autowired
    private ClassDetailsService classDetailsService;
    @Autowired
    private ClassDetailsRepository classDetailsRepository;

    @GetMapping
    public List<ClassDetails> findAll() {
        return classDetailsRepository.findAll();
    }

    @GetMapping("/{id}")
    public ClassDetails findById(@PathVariable("id") long id) {
        Optional<ClassDetails> classDetails = classDetailsRepository.findById(id);
        return classDetails.orElse(null);
    }

    @PostMapping
    public ClassDetails create(@RequestBody ClassDetails classDetails) {
        return classDetailsRepository.save(classDetails);
    }

    @PutMapping
    public ClassDetails update(@RequestBody ClassDetails classDetails) {
        return classDetailsRepository.save(classDetails);
    }

    @GetMapping("/class-details/{detailId}")
    public ResponseEntity<ClassDetails> getClassDetails(@PathVariable Long detailId) {
        Optional<ClassDetails> optionalClassDetails = classDetailsRepository.findById(detailId);
        if (optionalClassDetails.isPresent()) {
            ClassDetails classDetails = optionalClassDetails.get();
            return ResponseEntity.ok().body(classDetails);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }





}

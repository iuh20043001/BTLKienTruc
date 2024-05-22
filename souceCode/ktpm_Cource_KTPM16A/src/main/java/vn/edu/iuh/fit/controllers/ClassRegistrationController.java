package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.ClassDetails;
import vn.edu.iuh.fit.models.ClassRegistration;
import vn.edu.iuh.fit.repositories.ClassRegistrationRepository;
import vn.edu.iuh.fit.services.ClassRegistrationService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/class-registrations")
@CrossOrigin(origins = "*")
public class ClassRegistrationController {
    @Autowired
    private ClassRegistrationService classRegistrationService;
    @Autowired
    private ClassRegistrationRepository classRegistrationRepository;

    @GetMapping
    public List<ClassRegistration> findAll() {
        return classRegistrationRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassRegistration> getClassRegistration(@PathVariable("id") Long id) {
        Optional<ClassRegistration> classRegistration = classRegistrationService.findById(id);
        if (classRegistration.isPresent()) {
            return ResponseEntity.ok().body(classRegistration.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping
    public ClassRegistration update(@RequestBody ClassRegistration classRegistration) {
        return classRegistrationRepository.save(classRegistration);
    }
    @GetMapping("/class-registrations/{classId}")
    public ResponseEntity<ClassRegistration> getClassRegistrationDetails(@PathVariable Long classId) {
        ClassRegistration classRegistration = classRegistrationRepository.findById(classId).orElse(null);
        if (classRegistration == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(classRegistration);
        }
    }

    @GetMapping("/{classId}/class-details")
    public ResponseEntity<List<ClassDetails>> getClassDetails(@PathVariable Long classId) {
        List<ClassDetails> classDetails = classRegistrationService.getClassDetailsByClassId(classId);
        if (classDetails.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(classDetails);
        }
    }


    @GetMapping("/{classId}/class-details/count")
    public int getClassDetailsCount(@PathVariable Long classId) {
        ClassRegistration classRegistration = classRegistrationRepository.findById(classId).orElse(null);
        if (classRegistration != null) {
            List<ClassDetails> classDetailsList = classRegistration.getClassDetails();
            return classDetailsList.size();
        }
        return 0; // Trả về 0 nếu không tìm thấy lớp học phần

}}

package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.entity.ResponsePages;
import vn.edu.iuh.fit.models.Enrollment;
import vn.edu.iuh.fit.repositories.EnrollmentRepository;

@Service
public class EnrollmentService {
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    public Enrollment create(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public Enrollment update(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public void delete(long id) {
        enrollmentRepository.deleteById(id);
    }

    public Enrollment getById(long id) {
        return enrollmentRepository.findById(id).orElse(null);
    }

    public ResponsePages getAll(Pageable pageable) {
        return new ResponsePages(enrollmentRepository.findAll(pageable).getTotalPages(), enrollmentRepository.findAll(pageable).getContent());
    }
}

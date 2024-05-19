package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.ClassDetails;
import vn.edu.iuh.fit.repositories.ClassDetailsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClassDetailsService {
    @Autowired
    private ClassDetailsRepository classDetailsRepository;

    public Optional<ClassDetails> findById(Long id) {
        return classDetailsRepository.findById(id);
    }

    public ClassDetails save(ClassDetails classDetails) {
        return classDetailsRepository.save(classDetails);
    }

    public void deleteById(Long id) {
        classDetailsRepository.deleteById(id);
    }

    public List<ClassDetails> findAll() {
        return classDetailsRepository.findAll();
    }
}

package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.Major;
import vn.edu.iuh.fit.repositories.MajorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MajorService {
    @Autowired
    private MajorRepository majorRepository;

    public Optional<Major> findById(Long id) {
        return majorRepository.findById(id);
    }

    public Major save(Major major) {
        return majorRepository.save(major);
    }

    public void deleteById(Long id) {
        majorRepository.deleteById(id);
    }

    public List<Major> findAll() {
        return majorRepository.findAll();
    }
}

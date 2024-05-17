package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.entity.ResponsePages;
import vn.edu.iuh.fit.models.Grade;
import vn.edu.iuh.fit.repositories.GradeRepository;

@Service
public class GradeService {
    @Autowired
    private GradeRepository gradeRepository;

    public Grade create(Grade grade) {
        return gradeRepository.save(grade);
    }

    public Grade update(Grade grade) {
        return gradeRepository.save(grade);
    }

    public void delete(long id) {
        gradeRepository.deleteById(id);
    }

    public Grade getById(long id) {
        return gradeRepository.findById(id).orElse(null);
    }

    public ResponsePages getAll(Pageable pageable) {
        return new ResponsePages(gradeRepository.findAll(pageable).getTotalPages(), gradeRepository.findAll(pageable).getContent());
    }
}

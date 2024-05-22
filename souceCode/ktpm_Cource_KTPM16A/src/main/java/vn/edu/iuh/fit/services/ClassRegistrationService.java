package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.models.ClassDetails;
import vn.edu.iuh.fit.models.ClassRegistration;
import vn.edu.iuh.fit.repositories.ClassRegistrationRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class ClassRegistrationService {
    @Autowired
    private ClassRegistrationRepository classRegistrationRepository;

    public Optional<ClassRegistration> findById(Long id) {
        return classRegistrationRepository.findById(id);
    }

    public ClassRegistration save(ClassRegistration classRegistration) {
        return classRegistrationRepository.save(classRegistration);
    }

    public void deleteById(Long id) {
        classRegistrationRepository.deleteById(id);
    }

    public List<ClassRegistration> findAll() {
        return classRegistrationRepository.findAll();
    }

    public List<ClassDetails> getClassDetailsByClassId(Long classId) {
        ClassRegistration classRegistration = classRegistrationRepository.findById(classId).orElse(null);
        if (classRegistration != null) {
            return classRegistration.getClassDetails();
        }
        return Collections.emptyList(); // Trả về danh sách trống nếu không tìm thấy lớp học phần
    }

}

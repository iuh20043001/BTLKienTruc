package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.entity.ResponsePages;
import vn.edu.iuh.fit.models.Student;
import vn.edu.iuh.fit.repositories.StudentRepository;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public StudentService() {
    }

    public Student create(Student student) {
        return studentRepository.save(student);
    }

    public Student update(Student student) {
        return studentRepository.save(student);
    }

    public void delete(long id) {
        studentRepository.deleteById(id);
    }

    public Student getById(long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);  // Trả về null nếu không tìm thấy
    }

    public ResponsePages getAll(Pageable pageable) {
        return new ResponsePages(
                studentRepository.findAll(pageable).getTotalPages(),
                studentRepository.findAll(pageable).getContent()
        );
    }
}

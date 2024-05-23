package vn.edu.iuh.fit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.edu.iuh.fit.models.Class;
import vn.edu.iuh.fit.models.ClassDetails;
import vn.edu.iuh.fit.repositories.ClassRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class ClassController {
    @Autowired
    private ClassRepository classRepository;

    @GetMapping("/registered-courses")
    public ResponseEntity<?> getRegisteredCourses() {
        try {
            List<Class> registeredCourses = classRepository.findAll(); // Lấy danh sách các khóa học đã đăng ký từ cơ sở dữ liệu
            return new ResponseEntity<>(registeredCourses, HttpStatus.OK); // Trả về danh sách các khóa học đã đăng ký với mã trạng thái 200 OK
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); // Trả về lỗi nếu có lỗi xảy ra
        }
    }

    @PutMapping("/registered-courses/{id}")
    public ResponseEntity<?> updateRegisteredCourse(@PathVariable Integer id, @RequestBody Class updatedClass) {
        try {
            Optional<Class> optionalClass = classRepository.findById(id);
            if (optionalClass.isPresent()) {
                Class existingClass = optionalClass.get();
                existingClass.setName(updatedClass.getName()); // Cập nhật tên lớp học
                existingClass.setClassId(updatedClass.getClassId()); // Cập nhật mã lớp học
                // Cập nhật thêm các trường dữ liệu khác cần thiết

                Class savedClass = classRepository.save(existingClass);
                return new ResponseEntity<>(savedClass, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Class not found with id: " + id, HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PostMapping("/registered-courses")
    public ResponseEntity<?> registerCourse(@RequestBody Class newClass) {
        try {
            Class savedClass = classRepository.save(newClass);
            return new ResponseEntity<>(savedClass, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

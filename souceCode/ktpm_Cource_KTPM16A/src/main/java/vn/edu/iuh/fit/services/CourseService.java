package vn.edu.iuh.fit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.entity.ResponsePages;
import vn.edu.iuh.fit.models.Course;
import vn.edu.iuh.fit.repositories.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public Course create(Course course) {
        return courseRepository.save(course);
    }

    public Course update(Course course) {
        return courseRepository.save(course);
    }

    public void delete(long id) {
        courseRepository.deleteById(id);
    }

    public Course getByID(long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course getById(long id){
        return courseRepository.findById(id).orElse(null);
    }

    public ResponsePages getAll(Pageable pageable) {
        Page<Course> coursePage = courseRepository.findAll(pageable);
        return new ResponsePages(coursePage.getTotalPages(), coursePage.getContent());
    }
}

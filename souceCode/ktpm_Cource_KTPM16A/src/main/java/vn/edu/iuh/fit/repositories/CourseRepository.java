package vn.edu.iuh.fit.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Page<Course> findAll(Pageable pageable);
}

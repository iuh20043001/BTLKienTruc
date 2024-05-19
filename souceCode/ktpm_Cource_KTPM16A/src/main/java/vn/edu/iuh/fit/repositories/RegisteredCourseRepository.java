package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.RegisteredCourse;

@Repository
public interface RegisteredCourseRepository extends JpaRepository<RegisteredCourse, Long> {
}

package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.models.CurriculumCourse;

public interface CurriculumCourseRepository extends JpaRepository<CurriculumCourse, Integer> {
}

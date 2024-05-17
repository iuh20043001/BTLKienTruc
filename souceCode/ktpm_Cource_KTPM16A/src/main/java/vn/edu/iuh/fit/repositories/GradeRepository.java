package vn.edu.iuh.fit.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.Grade;

@Repository
public interface GradeRepository extends JpaRepository<Grade, Long> {
    Page<Grade> findAll(Pageable pageable);
}

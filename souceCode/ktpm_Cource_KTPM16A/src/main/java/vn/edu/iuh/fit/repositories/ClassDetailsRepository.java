package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.ClassDetails;

@Repository
public interface ClassDetailsRepository extends JpaRepository<ClassDetails, Long> {
}

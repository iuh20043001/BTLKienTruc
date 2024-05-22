package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.ClassDetails;
import vn.edu.iuh.fit.models.ClassRegistration;

import java.util.List;

@Repository
public interface ClassDetailsRepository extends JpaRepository<ClassDetails, Long> {
    List<ClassDetails> findByClassRegistration(ClassRegistration classRegistration);
}

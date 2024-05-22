package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.edu.iuh.fit.models.ClassDetails;
import vn.edu.iuh.fit.models.ClassRegistration;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassRegistrationRepository extends JpaRepository<ClassRegistration, Long> {

}

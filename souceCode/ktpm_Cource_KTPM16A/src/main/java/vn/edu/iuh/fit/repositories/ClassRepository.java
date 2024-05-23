package vn.edu.iuh.fit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.edu.iuh.fit.models.Class;

public interface ClassRepository extends JpaRepository<Class, Integer> {
}

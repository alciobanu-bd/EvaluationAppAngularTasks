package ro.alinagarea.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.alinagarea.clinica.model.Specialty;


public interface SpecialtyRepository extends JpaRepository<Specialty,Long> {
}

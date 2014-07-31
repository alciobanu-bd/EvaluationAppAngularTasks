package ro.alinagarea.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.alinagarea.clinica.model.Doctor;


public interface DoctorRepository extends JpaRepository<Doctor,Long>{
}

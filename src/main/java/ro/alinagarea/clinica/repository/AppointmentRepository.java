package ro.alinagarea.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.alinagarea.clinica.model.Appointment;


public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}

package ro.alinagarea.clinica.repository;

import ro.alinagarea.clinica.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonRepository extends JpaRepository<Person, Long> {
}

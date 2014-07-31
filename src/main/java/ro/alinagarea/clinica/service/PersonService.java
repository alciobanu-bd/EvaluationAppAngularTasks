package ro.alinagarea.clinica.service;

import ro.alinagarea.clinica.dto.PersonDTO;
import ro.alinagarea.clinica.model.Person;

import java.util.List;

public interface PersonService {

    public Person create(PersonDTO created);

    public Person delete(Long personId) throws PersonNotFoundException;

    public List<Person> findAll();

    public Person findById(Long id);

    public Person update(PersonDTO updated) throws PersonNotFoundException;
}

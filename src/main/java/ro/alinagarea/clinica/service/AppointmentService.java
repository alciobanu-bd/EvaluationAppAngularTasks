package ro.alinagarea.clinica.service;


import ro.alinagarea.clinica.dto.PersonDTO;
import ro.alinagarea.clinica.model.Appointment;

import java.text.ParseException;
import java.util.Date;

public interface AppointmentService {

    Appointment saveAppointmentFromDTO(PersonDTO personDTO) throws ParseException;

    Appointment updatedAppointmentFromDTO(PersonDTO personDTO, Long personId) throws ParseException;

    PersonDTO createDto(Long appointmentId);

    PersonDTO createDto(Long appointmentId, Long personId);
}

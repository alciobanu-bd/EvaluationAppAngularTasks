package ro.alinagarea.clinica.service;

import org.springframework.stereotype.Service;
import ro.alinagarea.clinica.dto.PersonDTO;
import ro.alinagarea.clinica.model.Appointment;
import ro.alinagarea.clinica.model.Person;
import ro.alinagarea.clinica.repository.AppointmentRepository;
import ro.alinagarea.clinica.repository.DoctorRepository;
import ro.alinagarea.clinica.repository.PersonRepository;
import ro.alinagarea.clinica.repository.SpecialtyRepository;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Resource
    AppointmentRepository appointmentRepository;

    @Resource
    PersonRepository personRepository;

    @Resource
    DoctorRepository doctorRepository;

    @Override
     public Appointment saveAppointmentFromDTO(PersonDTO personDTO) throws ParseException {
        Appointment appointment = new Appointment();
        Person person = new Person();

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date date = sdf.parse(personDTO.getAppointmentDate());

        person.setFirstName(personDTO.getFirstName());
        person.setLastName(personDTO.getLastName());
        person.setId(personDTO.getPersonId());
        personRepository.save(person);


        appointment.setId(personDTO.getId());
        appointment.setDate(date);
        appointment.setHour(personDTO.getAppointmentHour());
        appointment.setFkDoctor(doctorRepository.findOne(personDTO.getDoctor()));
        appointment.setFkPerson(person);

        appointmentRepository.save(appointment);

        return appointment;
    }

    @Override
    public Appointment updatedAppointmentFromDTO(PersonDTO personDTO, Long personId) throws ParseException {
        return null;
    }

    @Override
     public PersonDTO createDto(Long appointmentId) {
        PersonDTO personDTO = new PersonDTO();

        Appointment appointment = appointmentRepository.findOne(appointmentId);
        if (appointment != null) {
            personDTO.setId(appointmentId);
            personDTO.setAppointmentHour(appointment.getHour());
            personDTO.setAppointmentDate(appointment.getDate().toString());
            personDTO.setFirstName(appointment.getFkPerson().getFirstName());
            personDTO.setLastName(appointment.getFkPerson().getLastName());
            personDTO.setDoctorName(appointment.getFkDoctor().getFirstName() + " " +
                    appointment.getFkDoctor().getLastName());
            personDTO.setSpecialtyName(appointment.getFkDoctor().getFkSpecialty().getDescription());
        }
        return personDTO;
    }

    @Override
    public PersonDTO createDto(Long appointmentId, Long personId) {
        PersonDTO personDTO = new PersonDTO();

        Appointment appointment = appointmentRepository.findOne(appointmentId);
        if (appointment != null) {
            personDTO.setId(appointmentId);
            personDTO.setAppointmentHour(appointment.getHour());
            personDTO.setAppointmentDate(appointment.getDate().toString());
            personDTO.setFirstName(appointment.getFkPerson().getFirstName());
            personDTO.setLastName(appointment.getFkPerson().getLastName());
            personDTO.setDoctorName(appointment.getFkDoctor().getFirstName() + " " +
                    appointment.getFkDoctor().getLastName());
            personDTO.setSpecialtyName(appointment.getFkDoctor().getFkSpecialty().getDescription());
            personDTO.setPersonId(personId);
        }
        return personDTO;
    }

}

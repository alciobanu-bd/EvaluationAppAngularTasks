package ro.alinagarea.clinica.controller;

import org.springframework.beans.factory.annotation.Autowired;
import ro.alinagarea.clinica.dto.PersonDTO;
import ro.alinagarea.clinica.model.Appointment;
import ro.alinagarea.clinica.model.Doctor;
import ro.alinagarea.clinica.model.Person;
import ro.alinagarea.clinica.repository.AppointmentRepository;
import ro.alinagarea.clinica.repository.DoctorRepository;
import ro.alinagarea.clinica.service.AppointmentService;
import ro.alinagarea.clinica.service.DoctorService;
import ro.alinagarea.clinica.service.PersonNotFoundException;
import ro.alinagarea.clinica.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.text.ParseException;
import java.util.*;


@Controller
@SessionAttributes("person")
public class PersonController extends AbstractController {
    
    private static final Logger LOGGER = LoggerFactory.getLogger(PersonController.class);
    
    protected static final String ERROR_MESSAGE_KEY_DELETED_PERSON_WAS_NOT_FOUND = "error.message.deleted.not.found";
    protected static final String ERROR_MESSAGE_KEY_EDITED_PERSON_WAS_NOT_FOUND = "error.message.edited.not.found";
    
    protected static final String FEEDBACK_MESSAGE_KEY_PERSON_CREATED = "feedback.message.person.created";
    protected static final String FEEDBACK_MESSAGE_KEY_PERSON_DELETED = "feedback.message.person.deleted";
    protected static final String FEEDBACK_MESSAGE_KEY_PERSON_EDITED = "feedback.message.person.edited";
    
    protected static final String MODEL_ATTIRUTE_PERSON = "person";
    protected static final String MODEL_ATTRIBUTE_PERSONS = "persons";
    
    protected static final String PERSON_ADD_FORM_VIEW = "person/create";
    protected static final String PERSON_EDIT_FORM_VIEW = "person/edit";
    protected static final String PERSON_LIST_VIEW = "person/list";
    
    protected static final String REQUEST_MAPPING_LIST = "/";
    
    @Resource
    private PersonService personService;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private AppointmentRepository appointmentRepository;

    /**
     * Processes delete person requests.
     * @param id    The id of the deleted person.
     * @param attributes
     * @return
     */
    @RequestMapping(value = "/person/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id, RedirectAttributes attributes) {
        LOGGER.debug("Deleting person with id: " + id);

        try {
            Appointment appointment = appointmentRepository.findOne(id);
            Long person_id = appointment.getFkPerson().getId();

            appointmentRepository.delete(id);
            Person deleted = personService.delete(person_id);

            addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_PERSON_DELETED, deleted.getName());
        } catch (PersonNotFoundException e) {
            LOGGER.debug("No person found with id: " + id);
            addErrorMessage(attributes, ERROR_MESSAGE_KEY_DELETED_PERSON_WAS_NOT_FOUND);
        }

        return createRedirectViewPath(REQUEST_MAPPING_LIST);
    }

    /**
     * Processes create person requests.
     * @param model
     * @return  The name of the create person form view.
     */
    @RequestMapping(value = "/person/create", method = RequestMethod.GET) 
    public String showCreatePersonForm(Model model) {
        LOGGER.debug("Rendering create person form");
        Map<Long,Doctor> doctors = new LinkedHashMap<Long,Doctor>();
        List<Doctor> doctorList = doctorRepository.findAll();
        for (int i = 0; i < doctorList.size(); i++ ) {
            doctors.put((long)i+1,doctorList.get(i));
        }
        model.addAttribute(MODEL_ATTIRUTE_PERSON, new PersonDTO());
        model.addAttribute("doctors", doctors);
        return PERSON_ADD_FORM_VIEW;
    }

    /**
     * Processes the submissions of create person form.
     * @param created   The information of the created persons.
     * @param bindingResult
     * @param attributes
     * @return
     */
    @RequestMapping(value = "/person/create", method = RequestMethod.POST)
    public String submitCreatePersonForm(@Valid @ModelAttribute(MODEL_ATTIRUTE_PERSON) PersonDTO created, BindingResult bindingResult, RedirectAttributes attributes) throws ParseException {
        LOGGER.debug("Create person form was submitted with information: " + created);

        if (bindingResult.hasErrors()) {
            return PERSON_ADD_FORM_VIEW;
        }

        Person person = personService.create(created);
        created.setPersonId(person.getId());
        appointmentService.saveAppointmentFromDTO(created);

        addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_PERSON_CREATED, person.getName());

        return createRedirectViewPath(REQUEST_MAPPING_LIST);
    }

    /**
     * Processes edit person requests.
     * @param id    The id of the edited person.
     * @param model
     * @param attributes
     * @return  The name of the edit person form view.
     */
    @RequestMapping(value = "/person/edit/{id}", method = RequestMethod.GET)
    public String showEditPersonForm(@PathVariable("id") Long id, Model model, RedirectAttributes attributes) {
        LOGGER.debug("Rendering edit person form for person with id: " + id);
        
        Appointment appointment = appointmentRepository.findOne(id);

        if (appointment == null) {
            LOGGER.debug("No appointment found with id: " + id);
            addErrorMessage(attributes, ERROR_MESSAGE_KEY_EDITED_PERSON_WAS_NOT_FOUND);
            return createRedirectViewPath(REQUEST_MAPPING_LIST);            
        }

        Map<Long,Doctor> doctors = new LinkedHashMap<Long,Doctor>();
        List<Doctor> doctorList = doctorRepository.findAll();
        for (int i = 0; i < doctorList.size(); i++ ) {
            doctors.put((long)i+1,doctorList.get(i));
        }
        PersonDTO newAppointment = appointmentService.createDto(appointment.getId(),appointment.getFkPerson().getId());
        model.addAttribute(MODEL_ATTIRUTE_PERSON, newAppointment);
        model.addAttribute("doctors", doctors);

        //model.addAttribute(MODEL_ATTIRUTE_PERSON, constructFormObject(appointment.getFkPerson()));

        return PERSON_EDIT_FORM_VIEW;
    }

    /**
     * Processes the submissions of edit person form.
     * @param updated   The information of the edited person.
     * @param bindingResult
     * @param attributes
     * @return
     */
    @RequestMapping(value = "/person/edit", method = RequestMethod.POST)
    public String submitEditPersonForm(@Valid @ModelAttribute(MODEL_ATTIRUTE_PERSON) PersonDTO updated, BindingResult bindingResult, RedirectAttributes attributes) throws ParseException {
        LOGGER.debug("Edit person form was submitted with information: " + updated);
        
        /*if (bindingResult.hasErrors()) {
            LOGGER.debug("Edit person form contains validation errors. Rendering form view.");
            return PERSON_EDIT_FORM_VIEW;
        }            */

            //Person person = personService.update(updated);
            appointmentService.saveAppointmentFromDTO(updated);
            addFeedbackMessage(attributes, FEEDBACK_MESSAGE_KEY_PERSON_EDITED, updated.getFirstName());

        
        return createRedirectViewPath(REQUEST_MAPPING_LIST);
    }
    
    private PersonDTO constructFormObject(Person person) {
        PersonDTO formObject = new PersonDTO();
        
        formObject.setId(person.getId());
        formObject.setFirstName(person.getFirstName());
        formObject.setLastName(person.getLastName());
        
        return formObject;
    }

    /**
     * Processes requests to home page which lists all available persons.
     * @param model
     * @return  The name of the person list view.
     */
    @RequestMapping(value = REQUEST_MAPPING_LIST, method = RequestMethod.GET)
    public String showList(Model model) {
        LOGGER.debug("Rendering person list page");

        doctorService.insertSomeDoctors();

        List<Person> persons = personService.findAll();
        model.addAttribute(MODEL_ATTRIBUTE_PERSONS, persons);

        List<Appointment> appointments = appointmentRepository.findAll();
        List<PersonDTO> personDTOs = new LinkedList<PersonDTO>();
        for (int i = 0; i < appointments.size(); i++) {
            Long id = appointments.get(i).getId();
            personDTOs.add(appointmentService.createDto(id));
        }
        model.addAttribute("personDtos",personDTOs);

        return PERSON_LIST_VIEW;
    }

    /**
     * This setter method should only be used by unit tests
     * @param personService
     */
    protected void setPersonService(PersonService personService) {
        this.personService = personService;
    }
}

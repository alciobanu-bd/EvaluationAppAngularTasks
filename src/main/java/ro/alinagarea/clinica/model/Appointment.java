package ro.alinagarea.clinica.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "appointments")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="date")
    private Date date;

    @Column(name="hour")
    private int hour;

    @ManyToOne
    @JoinColumn(name="doctor_id", referencedColumnName = "id")
    private Doctor fkDoctor;

    @ManyToOne
    @JoinColumn(name="person_id", referencedColumnName = "id")
    private Person fkPerson;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Doctor getFkDoctor() {
        return fkDoctor;
    }

    public void setFkDoctor(Doctor fkDoctor) {
        this.fkDoctor = fkDoctor;
    }

    public Person getFkPerson() {
        return fkPerson;
    }

    public void setFkPerson(Person fkPerson) {
        this.fkPerson = fkPerson;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
}

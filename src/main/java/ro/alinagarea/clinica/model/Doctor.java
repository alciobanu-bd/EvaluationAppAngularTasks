package ro.alinagarea.clinica.model;

import javax.persistence.*;


@Entity
@Table(name = "doctors")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "specialty_id",referencedColumnName = "id")
    private Specialty fkSpecialty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Specialty getFkSpecialty() {
        return fkSpecialty;
    }

    public void setFkSpecialty(Specialty fkSpecialty) {
        this.fkSpecialty = fkSpecialty;
    }

    @Override
    public String toString() {
        return "Doctorul " + firstName + " " + lastName + " cu specializarea " + fkSpecialty.getDescription();
    }
}

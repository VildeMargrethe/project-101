package no.acntech.project101.employee;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Employee {

    //TODO Create the enitity for Employee -OK

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="FIRST_NAME") //når feks legger til ny ansatt så sider denne at fornavnet skal inn i kolonnen FIST_NAME i databasen
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    public Employee() {
        // Hibernate
    }

    public Employee(final String firstName, final String lastName, final LocalDate dateOfBirth) { //trenger egentlig ikke konstruktøren når har getter og settere, men greit å ha. For da blir variablene til objektet satt når lager det. Slipper da å kjøre metodene.
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Long getId() {
        return id;
    }
}

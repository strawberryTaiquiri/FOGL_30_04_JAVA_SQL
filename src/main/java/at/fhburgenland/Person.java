package at.fhburgenland;

import jakarta.persistence.*;

@Entity(name = "Person")
@Table(name= "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pnr", updatable = false, nullable = false)
    private int pnr;

    private String vorname;

    private String nachname;

    private Integer gehalt;


    public Person() {
        // TODO Initialization of fields of Person
    }

    // TODO Implement body of Person
}

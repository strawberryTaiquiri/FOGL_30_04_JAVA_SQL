package at.fhburgenland;

import jakarta.persistence.*;

@Entity(name = "Person")
@Table(name= "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pnr", updatable = false, nullable = false)
    private int pnr;

    @Column(name = "vorname", nullable = false, length = 50)
    private String vorname;

    @Column(name = "nachname", nullable = false, length = 50)
    private String nachname;

    @Column(name = "gehalt", nullable = false)
    private int gehalt;


    public Person() {
        // TODO Initialization of fields of Person
    }

    public Person(String vorname, String nachname, int gehalt){
        this.vorname = vorname;
        this.nachname = nachname;
        this.gehalt = gehalt;
    }

}

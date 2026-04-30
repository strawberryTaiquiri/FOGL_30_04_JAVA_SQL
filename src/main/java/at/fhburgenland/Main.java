package at.fhburgenland;

import jakarta.persistence.*;

public class Main {

    private static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("person");

    public static void main(String[] args) {
        System.out.println("Test");
        /* TO DO
            -) Connect Database
            -) Klasse zur Tabelle erstellen!
            -) Create Methods for
                -) addPerson
                -) readPerson
                -) readAllPersons --> Ausgabe ganze Tabelle
                -) update Person
                -) delete Person
         */
    }
}

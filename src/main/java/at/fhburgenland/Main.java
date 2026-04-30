package at.fhburgenland;

import jakarta.persistence.*;

public class Main {

    private static EntityManagerFactory EMF = Persistence.createEntityManagerFactory("person");

    public static void main(String[] args) {
        System.out.println("Test");
        /* TODO:
            -) Connect Database
            -) Klasse zur Tabelle erstellen!
            -) Create Methods for
                -) addPersons
                -) readPerson
                -) readAllPersons --> Ausgabe ganze Tabelle
                -) update Person
                -) delete Person
         */

        EMF.close();
    }

    public static void addPerson(String vorname, String nachname, int Gehalt){
        EntityManager em = EMF.createEntityManager();
        EntityTransaction et = null;

        try{

        } catch (Exception ex){
            System.out.println("ex = " + ex);
        } finally {
            em.close();
        }




    }
}

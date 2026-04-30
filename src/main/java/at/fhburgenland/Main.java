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

        addPerson("max", "musterman", 1000);

        EMF.close();
    }

    public static void addPerson(String vorname, String nachname, int gehalt){
        EntityManager em = EMF.createEntityManager();
        EntityTransaction et = null;

        try{
            et = em.getTransaction();
            et.begin();
            Person p = new Person(vorname, nachname, gehalt);
            em.persist(p);
            et.commit();

        } catch (Exception ex){
            if(et != null){
                et.rollback();
            }
        } finally {
            em.close();
        }




    }
}

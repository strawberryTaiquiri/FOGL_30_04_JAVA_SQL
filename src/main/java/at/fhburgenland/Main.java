package at.fhburgenland;

import jakarta.persistence.*;

import java.util.List;

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

        readAll();

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


    public static void readAll(){

        EntityManager em = EMF.createEntityManager();

        String query = "SELECT p from Person p";

        TypedQuery<Person> tq = em.createQuery(query, Person.class);

        List<Person> personList = null;

        try{
            personList = tq.getResultList();

            for (Person person : personList) {
                System.out.println(person.getPnr() +" "+ person.getVorname() + " "+
                        person.getNachname() +" "+ person.getGehalt());
            }
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            em.close();
        }



    }
}

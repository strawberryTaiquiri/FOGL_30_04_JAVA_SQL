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

        // findPersonByFamilyName("Reisinger");
        // findPersonByPnr(4);

        // updatePerson("maxUpdated", "max", 777777, 1);
        deletePerson(1);

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

    public static void findPersonByFamilyName(String nachname){

        EntityManager em = EMF.createEntityManager();
        String query = "SELECT p from Person p where p.nachname = :nname";
        TypedQuery<Person> tq = em.createQuery(query, Person.class);

        tq.setParameter("nname", nachname);

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


    public static void findPersonByPnr(int pnr){

        EntityManager em = EMF.createEntityManager();
        Person person;

        try{
            person = em.find(Person.class, pnr);
            em.persist(person);

            System.out.println(person.getPnr() +" "+ person.getVorname() + " "+ person.getNachname() +" "+ person.getGehalt());
        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            em.close();
        }
    }

    public static void updatePerson(String vorname, String nachname, int gehalt, int pnr){

        EntityManager em = EMF.createEntityManager();
        EntityTransaction et = null;
        Person person = null;

        try{
            et = em.getTransaction();
            et.begin();

            person = em.find(Person.class, pnr);

            if(person == null){
                throw new RuntimeException("keine Person gefuden");
            }

            person.setGehalt(gehalt);
            person.setNachname(nachname);
            person.setVorname(vorname);

            em.persist(person);

            et.commit();

        } catch (Exception ex) {
            if(et != null){
                et.rollback();
            }
        } finally {
            em.close();
        }
    }

    public static void deletePerson(int pnr){

        EntityManager em = EMF.createEntityManager();
        EntityTransaction et = null;
        Person person = null;

        try{
            et = em.getTransaction();
            et.begin();

            person = em.find(Person.class, pnr);

            if(person == null){
                throw new RuntimeException("keine Person gefuden");
            }

            em.remove(person);
            et.commit();
        } catch (Exception ex) {
            if(et != null){
                et.rollback();
            }
        } finally {
            em.close();
        }
    }
}

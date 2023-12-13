package lk.ijse.dep11.jpa;

import lk.ijse.dep11.jpa.entity.Customer;
import lk.ijse.dep11.jpa.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ContextDemo7 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {

            Customer customer = new Customer(10, "Gunaya", "Hoamagama");
            em.persist(customer);
            System.out.println("Is customer inside the context? " + em.contains(customer));
            em.detach(customer);
            System.out.println("Is customer inside the context? " + em.contains(customer));

            System.out.println("----------------------");

            Employee employee = new Employee("Gunaya", "011-1234567");
            em.persist(employee);
            System.out.println("Is employee inside the context? " + em.contains(employee));
            em.persist(employee);
            System.out.println("Is employee inside the context? " + em.contains(employee));

            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        } finally {
            em.close();
            emf.close();
        }
    }
}

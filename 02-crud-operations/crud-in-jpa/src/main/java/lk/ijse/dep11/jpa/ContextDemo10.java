package lk.ijse.dep11.jpa;

import lk.ijse.dep11.jpa.entity.Customer;
import lk.ijse.dep11.jpa.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ContextDemo10 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {

            Customer customer = new Customer(3, "Suranga", "Panadura");
            em.persist(customer);           // INSERT INTO
            em.remove(customer);            // DELETE
            Employee employee = new Employee("Ruwan", "Galle");
            em.persist(employee);
            System.out.println("-------");
//            em.persist(customer);           // INSERT INTO

            System.out.println("------");
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

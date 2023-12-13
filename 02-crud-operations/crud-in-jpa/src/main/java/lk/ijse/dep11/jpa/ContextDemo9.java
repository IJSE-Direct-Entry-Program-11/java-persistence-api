package lk.ijse.dep11.jpa;

import lk.ijse.dep11.jpa.entity.Customer;
import lk.ijse.dep11.jpa.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ContextDemo9 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {

            Customer customer = new Customer(3, "Suranga", "Panadura");
            em.persist(customer);
            em.detach(customer);
            em.clear();

            Employee employee = em.find(Employee.class, 1);
            employee.setContact("078-1345678");

            System.out.println("-----");
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

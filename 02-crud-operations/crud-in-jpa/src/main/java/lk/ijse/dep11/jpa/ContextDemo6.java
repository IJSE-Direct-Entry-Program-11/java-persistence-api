package lk.ijse.dep11.jpa;

import lk.ijse.dep11.jpa.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ContextDemo6 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {

            Employee employee = em.find(Employee.class, 3);
            System.out.println(employee);
            employee.setName("Sirimal");
            employee.setContact("070-1234567");
            System.out.println(employee);
            em.refresh(employee);
            System.out.println(employee);
            em.detach(employee);
            System.out.println("Is employee inside the context? " +
                    em.contains(employee));
            em.refresh(employee);

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

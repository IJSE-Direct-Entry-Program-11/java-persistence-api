package lk.ijse.dep11.app;

import lk.ijse.dep11.app.entity.Customer;
import lk.ijse.dep11.app.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.time.LocalDate;

public class OneToManyDemo1 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {

            Customer c001 = new Customer("C001", "Kasun", "Galle");
            Order od001 = new Order("OD001", Date.valueOf(LocalDate.now()), c001);
            Order od002 = new Order("OD002", Date.valueOf(LocalDate.now()), c001);
            em.persist(c001);
            em.persist(od001);
            em.persist(od002);

            Customer c002 = new Customer("C002", "Nuwan", "Matara");
            Order od003 = new Order("OD003", Date.valueOf(LocalDate.now()), c002);
            em.persist(c002);
            em.persist(od003);

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

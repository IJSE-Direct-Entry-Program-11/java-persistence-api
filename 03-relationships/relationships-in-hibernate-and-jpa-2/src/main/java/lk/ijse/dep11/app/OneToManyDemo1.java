package lk.ijse.dep11.app;

import lk.ijse.dep11.app.entity.Customer;
import lk.ijse.dep11.app.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class OneToManyDemo1 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            Customer kasun = new Customer("C001", "Kasun", "077-1234567");
            Customer nuwan = new Customer("C002", "Nuwan", "078-1234567");
            Customer ruwan = new Customer("C003", "Ruwan", "075-1234567");

            Order od001 = new Order("OD001", Date.valueOf(LocalDate.now()));
            Order od002 = new Order("OD002", Date.valueOf(LocalDate.now()));

            /* Add a record to the associate entity */
            od001.setCustomer(nuwan);

            List.of(kasun, nuwan, ruwan, od001, od002).forEach(em::persist);

            em.getTransaction().commit();
        }catch (Throwable t){
            em.getTransaction().rollback();
            throw t;
        }finally {
            em.close();
            emf.close();
        }
    }
}

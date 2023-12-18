package lk.ijse.dep11.app;

import lk.ijse.dep11.app.entity.Customer;
import lk.ijse.dep11.app.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class OneToManyDemo2 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try{
            Order od001 = em.find(Order.class, "OD001");
            System.out.println(od001.getCustomer());

            // Delete a record in the associate entity
            od001.setCustomer(null);

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

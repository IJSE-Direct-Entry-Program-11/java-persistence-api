package lk.ijse.dep11.app;

import lk.ijse.dep11.app.entity.Customer;
import lk.ijse.dep11.app.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

public class OneToManyDemo2 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {

//            Order order = em.find(Order.class, "OD003");
//            System.out.println(order.getCustomer());
//
            Customer c002 = em.find(Customer.class, "C002");
            Customer c001 = em.find(Customer.class, "C001");
//            Set<Order> orderSet = customer.getOrderSet();
//            orderSet.forEach(System.out::println);

            Order od001 = em.find(Order.class, "OD001");
            //System.out.println(od001.getCustomer());
            //od001.setCustomer(c002);

            //c002.getOrderSet().remove(od001);
            //c001.getOrderSet().add(od001);
            c001.addOrder(od001);
//            c001.removeOrder(od001);

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

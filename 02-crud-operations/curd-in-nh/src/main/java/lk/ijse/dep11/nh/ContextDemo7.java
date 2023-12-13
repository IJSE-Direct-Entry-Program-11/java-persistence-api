package lk.ijse.dep11.nh;

import lk.ijse.dep11.nh.db.HibernateUtil;
import lk.ijse.dep11.nh.entity.Customer;
import lk.ijse.dep11.nh.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ContextDemo7 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                Customer customer = new Customer(2, "Upul", "Maharagam");
                session.refresh(customer);
//                System.out.println("Is customer inside the context? " +
//                        session.contains(customer));
                customer.setName("Thisara");

                tx.commit();
            }catch (Throwable t){
                tx.rollback();
                throw t;
            }
        }
    }
}

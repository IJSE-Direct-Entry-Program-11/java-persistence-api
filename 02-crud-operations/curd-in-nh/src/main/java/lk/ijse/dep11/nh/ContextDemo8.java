package lk.ijse.dep11.nh;

import lk.ijse.dep11.nh.db.HibernateUtil;
import lk.ijse.dep11.nh.entity.Customer;
import lk.ijse.dep11.nh.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ContextDemo8 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                Customer customer = new Customer(10, "Gunaya", "Hoamagama");
                session.save(customer);
                System.out.println("Is customer inside the context? " + session.contains(customer));
                session.evict(customer);
                System.out.println("Is customer inside the context? " + session.contains(customer));

                System.out.println("----------------------");

                Employee employee = new Employee("Gunaya", "011-1234567");
                session.save(employee);
                System.out.println("Is employee inside the context? " + session.contains(employee));
                session.evict(employee);
                System.out.println("Is employee inside the context? " + session.contains(employee));

                tx.commit();
            }catch (Throwable t){
                tx.rollback();
                throw t;
            }
        }
    }
}

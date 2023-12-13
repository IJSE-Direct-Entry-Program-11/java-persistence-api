package lk.ijse.dep11.nh;

import lk.ijse.dep11.nh.db.HibernateUtil;
import lk.ijse.dep11.nh.entity.Customer;
import lk.ijse.dep11.nh.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ContextDemo9 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                Customer customer = new Customer(3, "Suranga", "Panadura");
                session.save(customer);
                session.evict(customer);
                session.clear();

                Employee employee = session.get(Employee.class, 1);
                employee.setContact("078-1345678");

                System.out.println("-----");

                tx.commit();
            }catch (Throwable t){
                tx.rollback();
                throw t;
            }
        }
    }
}

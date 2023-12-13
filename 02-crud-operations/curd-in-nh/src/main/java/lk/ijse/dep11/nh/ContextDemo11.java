package lk.ijse.dep11.nh;

import lk.ijse.dep11.nh.db.HibernateUtil;
import lk.ijse.dep11.nh.entity.Customer;
import lk.ijse.dep11.nh.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ContextDemo11 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                Employee employee = new Employee(5, "jfkdlsja", "fjakls");
                session.delete(employee);

                tx.commit();
            }catch (Throwable t){
                tx.rollback();
                throw t;
            }
        }
    }
}

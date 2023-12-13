package lk.ijse.dep11.nh;

import lk.ijse.dep11.nh.db.HibernateUtil;
import lk.ijse.dep11.nh.entity.Customer;
import lk.ijse.dep11.nh.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class SaveOrUpdateDemo1 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                Customer customer = new Customer(3, "Ruwan", "Matara");
                session.saveOrUpdate(customer);
                System.out.println("Is customer inside the context? " +
                        session.contains(customer));

//                Employee employee = new Employee("Amith", "078-1234567");
//                session.saveOrUpdate(employee);
//                System.out.println("Is employee inside the context? " +
//                        session.contains(employee));

                tx.commit();
            }catch (Throwable t){
                tx.rollback();
                throw t;
            }
        }
    }
}

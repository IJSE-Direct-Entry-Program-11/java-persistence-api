package lk.ijse.dep11.nh;

import lk.ijse.dep11.nh.db.HibernateUtil;
import lk.ijse.dep11.nh.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ContextDemo6 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                Employee employee = session.get(Employee.class, 3);
                System.out.println(employee);
                employee.setName("Sirimal");
                employee.setContact("070-1234567");
                System.out.println(employee);
                session.refresh(employee);
                System.out.println(employee);
                session.evict(employee);
                System.out.println("Is employee inside the context? " +
                        session.contains(employee));
                session.refresh(employee);
                System.out.println("Is employee inside the context? " +
                        session.contains(employee));

                tx.commit();
            }catch (Throwable t){
                tx.rollback();
                throw t;
            }
        }
    }
}

package lk.ijse.dep11.app;

import lk.ijse.dep11.app.db.HibernateUtil;
import lk.ijse.dep11.app.entity.Employee;
import lk.ijse.dep11.app.entity.Spouse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OneToOneDemo3 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                Employee thisara = session.get(Employee.class, 1);
                System.out.println(thisara);

                Spouse ukkunNangi = new Spouse(2, "Ukkun Nangi", "022-1234567", thisara);
                session.save(ukkunNangi);

                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                throw t;
            }
        }
    }
}

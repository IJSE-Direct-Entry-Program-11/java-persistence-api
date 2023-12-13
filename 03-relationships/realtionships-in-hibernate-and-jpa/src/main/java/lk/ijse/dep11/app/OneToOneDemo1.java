package lk.ijse.dep11.app;

import lk.ijse.dep11.app.db.HibernateUtil;
import lk.ijse.dep11.app.entity.Employee;
import lk.ijse.dep11.app.entity.Spouse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OneToOneDemo1 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                Employee thisara = new Employee(1, "Thisara", "011-1234567", "Galle");
                Employee shehan = new Employee(2, "Shehan", "033-1234567", "Moratuwa");

                Spouse sukumali = new Spouse(1, "Sukumali", "011-1234567", thisara);

                session.save(thisara);
                session.save(shehan);
                session.save(sukumali);

                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                throw t;
            }
        }
    }
}

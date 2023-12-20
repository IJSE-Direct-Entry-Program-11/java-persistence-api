package lk.ijse.dep11.jpa.rel;

import lk.ijse.dep11.jpa.rel.db.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OneToOneDemo1 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                System.out.println(session);
                tx.commit();
            }catch (Throwable t){
                tx.rollback();
                throw t;
            }
        }
    }
}

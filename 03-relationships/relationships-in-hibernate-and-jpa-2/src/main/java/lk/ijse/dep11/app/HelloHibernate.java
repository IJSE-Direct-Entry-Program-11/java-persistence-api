package lk.ijse.dep11.app;

import lk.ijse.dep11.app.db.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HelloHibernate {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {
                System.out.println(session);
            }catch (Throwable t){
                tx.rollback();
                throw t;
            }
        }
    }
}
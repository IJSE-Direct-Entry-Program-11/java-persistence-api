package lk.ijse.dep11.nh;

import lk.ijse.dep11.nh.db.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HelloHibernate {

    public static void main(String[] args) {
        // EntityManagerFactory         // SessionFactory
        // EntityManager                // Session
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        System.out.println(session);
        session.close();
        sf.close();
    }
}

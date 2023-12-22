package lk.ijse.dep11.jpa.queries;

import lk.ijse.dep11.jpa.queries.db.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HQLDemo1 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                Query query = session.createQuery("SELECT a FROM Book b RIGHT OUTER JOIN Author a WITH b.author = a.id WHERE b.isbn IS NULL");
                query.getResultList().forEach(System.out::println);

                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                throw t;
            }
        }
    }
}

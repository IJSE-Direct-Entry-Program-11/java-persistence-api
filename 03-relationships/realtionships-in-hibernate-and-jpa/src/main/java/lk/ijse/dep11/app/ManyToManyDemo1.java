package lk.ijse.dep11.app;

import lk.ijse.dep11.app.db.HibernateUtil;
import lk.ijse.dep11.app.entity.Actor;
import lk.ijse.dep11.app.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ManyToManyDemo1 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                Actor thisara = new Actor(1, "Thisara");
                Actor pubudu = new Actor(2, "Pubudu");
                Actor nuwan = new Actor(3, "Nuwan");
                Actor shehan = new Actor(4, "Shehan");

                Movie movie1 = new Movie("M001", "Iron Man", "Action");
                Movie movie2 = new Movie("M002", "Live Free or Die Hard", "Action");

                session.save(thisara);
                session.save(pubudu);
                session.save(nuwan);
                session.save(shehan);
                session.save(movie1);
                session.save(movie2);

                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                throw t;
            }
        }
    }
}

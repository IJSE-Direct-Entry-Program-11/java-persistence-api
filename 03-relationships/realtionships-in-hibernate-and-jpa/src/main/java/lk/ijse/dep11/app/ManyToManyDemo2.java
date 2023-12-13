package lk.ijse.dep11.app;

import lk.ijse.dep11.app.db.HibernateUtil;
import lk.ijse.dep11.app.entity.Actor;
import lk.ijse.dep11.app.entity.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ManyToManyDemo2 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                Actor thisara = session.get(Actor.class, 1);
                Actor pubudu = session.get(Actor.class, 2);

                Movie movie1 = session.get(Movie.class, "M001");
                Movie movie2 = session.get(Movie.class, "M002");

//                thisara.getMovieSet().add(movie1);
//                pubudu.getMovieSet().add(movie1);
                pubudu.getMovieSet().add(movie2);
                pubudu.getMovieSet().remove(movie1);


                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                throw t;
            }
        }
    }
}

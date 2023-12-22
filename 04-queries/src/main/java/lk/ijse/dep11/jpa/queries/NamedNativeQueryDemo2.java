package lk.ijse.dep11.jpa.queries;

import lk.ijse.dep11.jpa.queries.db.HibernateUtil;
import lk.ijse.dep11.jpa.queries.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

public class NamedNativeQueryDemo2 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                // session.getNamedNativeQuery(SQLQueryName): NativeQuery<?>
                // session.createNamedQuery(SQLQueryName): Query<?>
                // session.createNamedQuery(SQLQueryName, ResultClass R): Query<R>

                NativeQuery<?> query1 = session.getNamedNativeQuery("findAuthors");
                query1.list().forEach(System.out::println);

                Query<?> query2 = session.createNamedQuery("findAuthors");
                query2.list().forEach(System.out::println);

                Query<Author> query3 = session.createNamedQuery("findAuthorsByContact", Author.class)
                        .setParameter(1, "077-1234567");
                System.out.println(query3.uniqueResult());

                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                throw t;
            }
        }
    }
}

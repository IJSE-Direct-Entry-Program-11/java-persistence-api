package lk.ijse.dep11.jpa.queries;

import lk.ijse.dep11.jpa.queries.db.HibernateUtil;
import lk.ijse.dep11.jpa.queries.entity.Author;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

public class NativeQueryDemo5 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                // session.createNativeQuery(SQL): NativeQuery<?>
                // session.createNativeQuery(SQL, ResultClass R): NativeQuery<R>

                NativeQuery<?> query1 = session
                        .createNativeQuery("SELECT * FROM author");
                List<?> authorList1 = query1.list();
                authorList1.forEach(System.out::println);

                NativeQuery<Author> query2 = session
                        .createNativeQuery("SELECT * FROM author", Author.class);
                List<Author> authorList2 = query2.list();
                authorList2.forEach(System.out::println);

                NativeQuery<Author> query3 = session
                        .createNativeQuery("SELECT * FROM author WHERE id = 'adsjkfja'", Author.class);
                System.out.println(query3.uniqueResult());

                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                throw t;
            }
        }
    }
}

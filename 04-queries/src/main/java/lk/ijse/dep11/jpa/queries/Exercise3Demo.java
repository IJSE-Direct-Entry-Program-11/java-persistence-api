package lk.ijse.dep11.jpa.queries;

import lk.ijse.dep11.jpa.queries.db.HibernateUtil;
import lk.ijse.dep11.jpa.queries.entity.Author;
import lk.ijse.dep11.jpa.queries.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Exercise3Demo {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                Query<Author> query1 = session
                        .createQuery("FROM Author a WHERE a.contact = :contact", Author.class);

                query1.setParameter("contact", "077-1234567")
                        .getResultList().forEach(System.out::println);

                Query<Book> query2 = session.createQuery("FROM Book b WHERE b.name LIKE CONCAT('%',:query,'%')",
                        Book.class);

                query2.setParameter("query", "the").getResultList().forEach(System.out::println);

                Query<Book> query3 = session.createQuery("SELECT b FROM Book b INNER JOIN Author a WITH b.author = a" +
                        " WHERE a.name = :name", Book.class);

                query3.setParameter("name", "Toby Grimes").getResultList().forEach(System.out::println);

                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                throw t;
            }
        }
    }
}

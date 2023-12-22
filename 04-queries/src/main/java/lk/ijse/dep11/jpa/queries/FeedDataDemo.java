package lk.ijse.dep11.jpa.queries;

import com.github.javafaker.Faker;
import lk.ijse.dep11.jpa.queries.db.HibernateUtil;
import lk.ijse.dep11.jpa.queries.entity.Author;
import lk.ijse.dep11.jpa.queries.entity.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class FeedDataDemo {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                Faker faker = new Faker();
                for (int i = 1; i < 10; i++) {
                    Author author = new Author(String.format("A%03d", i), faker.name().name(),
                            faker.regexify("0\\d{2}-\\d{7}"));

                    session.merge(author);

                    for (int j = 1; j < Math.ceil(Math.random() * 5); j++) {
                        Book book = new Book(author.getId() + String.format("-B%03d", j),
                                faker.book().title(), faker.book().genre(), author);
                        session.merge(book);
                    }
                }

                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                throw t;
            }
        }
    }
}

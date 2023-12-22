package lk.ijse.dep11.jpa.queries;

import lk.ijse.dep11.jpa.queries.entity.Author;

import javax.persistence.*;
import java.util.List;

public class JPQLDemo1 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {

            // em.createQuery(JPQL): Query
            // em.createQuery(JPQL, ResultClass R): TypedQuery<R>

            // SQL  : SELECT * FROM author
            // JPQL : SELECT a FROM lk.ijse.dep11.entity.Author a

            // SQL  : SELECT * FROM author WHERE name = ?
            // JPQL : SELECT a FROM lk.ijse.dep11.entity.Author a WHERE a.name = ?

//            TypedQuery<Author> query = em
//                    .createQuery("SELECT a FROM Author a",
//                    Author.class);
//            query.getResultList().forEach(System.out::println);
//
//            Query query2 = em.createQuery("SELECT upper(a.name) FROM Author a", String.class);
//            query2.getResultList().forEach(System.out::println);

//            SQL:
//            SELECT b.author, a.name, COUNT(b.author) AS BOOK_COUNT
//            FROM book b
//            INNER JOIN author a ON b.author = a.id
//            GROUP BY b.author;

            Query query = em.createQuery("SELECT a.id, a.name, COUNT(b.author) FROM Book b " +
                    "INNER JOIN b.author a  GROUP BY b.author", Tuple.class);

            List<Tuple> resultList = query.getResultList();
            for (Tuple tuple : resultList) {
                System.out.printf("%s: %s: %s \n", tuple.get(0), tuple.get(1), tuple.get(2));
            }

            em.getTransaction().commit();
        } catch (Throwable t) {
            em.getTransaction().rollback();
            throw t;
        } finally {
            em.close();
            emf.close();
        }
    }
}

package lk.ijse.dep11.jpa.queries;

import lk.ijse.dep11.jpa.queries.entity.Author;

import javax.persistence.*;
import java.util.List;

public class NamedNativeQueryDemo1 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {

            // em.createNamedQuery(SQLQueryName): Query
            // em.createNamedQuery(SQLQueryName, ResultClass R): TypedQuery<R>

            Query query = em.createNamedQuery("findAuthors");
            List<Author> authorList = query.getResultList();
            authorList.forEach(System.out::println);

            TypedQuery<Author> query2 = em.createNamedQuery("findAuthorsByName", Author.class)
                    .setParameter("name", "C");
            query2.getResultList().forEach(System.out::println);

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

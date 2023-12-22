package lk.ijse.dep11.jpa.queries;

import javax.persistence.*;
import java.util.List;

public class JPQLDemo2 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {

            // em.createQuery(JPQL): Query
            // em.createQuery(JPQL, ResultClass): TypedQuery<R>

            List resultList = em.createQuery("SELECT a FROM Book b RIGHT OUTER JOIN b.author a WHERE b.isbn IS NULL")
                    .getResultList();
            resultList.forEach(System.out::println);

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

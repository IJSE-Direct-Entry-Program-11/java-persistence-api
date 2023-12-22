package lk.ijse.dep11.jpa.queries;

import lk.ijse.dep11.jpa.queries.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class NativeQueryDemo3 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {

            // em.createNativeQuery(SQL): Query
            // em.createNativeQuery(SQL, ResultClass): Query

            Query query = em.createNativeQuery("SELECT * FROM author", Author.class);
            query.setFirstResult(5);
            query.setMaxResults(2);
            List authorList = query.getResultList();
            authorList.forEach(System.out::println);

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

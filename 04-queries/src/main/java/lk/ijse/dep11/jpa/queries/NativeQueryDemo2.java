package lk.ijse.dep11.jpa.queries;

import lk.ijse.dep11.jpa.queries.entity.Author;

import javax.persistence.*;
import java.util.List;

public class NativeQueryDemo2 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {

            // em.createNativeQuery(SQL): Query
            // em.createNativeQuery(SQL, ResultClass): Query

            // (1)
            Query query1 = em.createNativeQuery("SELECT * FROM author", Author.class);
            query1.getSingleResult(); // NonUniqueResultException

            // (2)
            Query query2 = em.createNativeQuery("SELECT * FROM author WHERE id='A001'", Author.class);
            query2.getSingleResult(); // Okay

            // (3)
            Query query3 = em.createNativeQuery("SELECT * FROM author WHERE id='fdas'", Author.class);
            query3.getSingleResult(); // NoResultException

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

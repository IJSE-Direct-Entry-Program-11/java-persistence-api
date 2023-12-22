package lk.ijse.dep11.jpa.queries;

import lk.ijse.dep11.jpa.queries.entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class NativeQueryDemo4 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {

            // em.createNativeQuery(SQL): Query
            // em.createNativeQuery(SQL, ResultClass): Query

            // (1) Positional Parameters ?<position>
//            Query query = em
//            .createNativeQuery("INSERT INTO author (id, name, contact) VALUES (?2, ?1, ?1)");
//
//            query.setParameter(1, "Kasun");
//            query.setParameter(2, "A010");

            // (2) Named Parameters :<name>
            Query query = em
                .createNativeQuery("INSERT INTO author (id, name, contact) VALUES (:id, :b, :c)");
            query.setParameter("id", "A010");
            query.setParameter("b", "Kasun");
            query.setParameter("c", "077-1234567");

            query.executeUpdate();

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

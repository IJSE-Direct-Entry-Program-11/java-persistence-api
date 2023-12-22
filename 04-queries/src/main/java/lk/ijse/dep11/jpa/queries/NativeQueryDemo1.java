package lk.ijse.dep11.jpa.queries;

import lk.ijse.dep11.jpa.queries.entity.Author;

import javax.persistence.*;
import java.util.List;

public class NativeQueryDemo1 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {

            // em.createNativeQuery(SQL): Query
            // em.createNativeQuery(SQL, ResultClass): Query

//            List<Object[]> authorList = query1.getResultList();
//            for (Object[] row : authorList) {
//                System.out.printf("%s - %s - %s \n", row[0], row[1], row[2]);
//            }

            Query query1 = em.createNativeQuery("SELECT * FROM author", Tuple.class);
            List<Tuple> authorList = query1.getResultList();
            for (Tuple tuple : authorList) {
                System.out.printf("%s - %s - %s \n", tuple.get("id"), tuple.get("name"), tuple.get("contact"));
            }

//            List<Author> authorList = query1.getResultList();
//            for (Author author : authorList) {
//                System.out.println(author);
//            }

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

package lk.ijse.dep11.jpa.queries;

import lk.ijse.dep11.jpa.queries.entity.Author;
import lk.ijse.dep11.jpa.queries.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Exercise1Demo {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {

            Query query1 = em
            .createNativeQuery("SELECT * FROM author WHERE contact = :contact", Author.class);

//            query1.setParameter("contact", "077-1234567")
//                            .getResultList().forEach(System.out::println);

            Query query2 = em.
            createNativeQuery("SELECT * FROM book WHERE name LIKE CONCAT('%',:query,'%')",
                    Book.class);

//            query2.setParameter("query", "the").getResultList().forEach(System.out::println);

            Query query3 = em
            .createNativeQuery("SELECT b.* FROM book b INNER JOIN author " +
                    "ON b.author_id = author.id WHERE author.name = :name", Book.class);


            query3.setParameter("name", "Toby Grimes").getResultList().forEach(System.out::println);


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

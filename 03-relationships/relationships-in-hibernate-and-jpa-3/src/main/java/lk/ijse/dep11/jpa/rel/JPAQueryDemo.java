package lk.ijse.dep11.jpa.rel;

import lk.ijse.dep11.jpa.rel.entity.Student;

import javax.persistence.*;
import java.util.List;

public class JPAQueryDemo {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {

            // JPA (JPQL , SQL)
            //em.createQuery("JPQL")
            TypedQuery<Student> query =
                    em.createQuery("SELECT s FROM lk.ijse.dep11.jpa.rel.entity.Student s",
                    Student.class);

            List<Student> resultList = query.getResultList();
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

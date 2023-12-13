package lk.ijse.dep11.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HelloJPA {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dep11");
        EntityManager em = emf.createEntityManager();
        System.out.println(em);
        em.close();
        emf.close();
    }
}

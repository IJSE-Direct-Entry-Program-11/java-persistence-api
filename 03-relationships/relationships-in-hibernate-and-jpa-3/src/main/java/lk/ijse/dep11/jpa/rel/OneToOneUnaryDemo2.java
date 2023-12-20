package lk.ijse.dep11.jpa.rel;

import lk.ijse.dep11.jpa.rel.entity.Employee2;
import lk.ijse.dep11.jpa.rel.entity.Module;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class OneToOneUnaryDemo2 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {

            Module os = new Module("M001", "Operating System", 4);
            Module pf = new Module("M002", "Programming Fundamentals", 4);
            Module rm = new Module("M003", "Relational Model", 4);
            Module rdbms = new Module("M004", "RDBMS", 4);
            Module oop = new Module("M005", "OOP", 4);
            Module concurrency = new Module("M007", "Concurrency", 4);
            Module security = new Module("M008", "Security", 4);

            pf.getPreRequisitesModules().add(os);

            rdbms.getPreRequisitesModules().add(os);
            rdbms.getPreRequisitesModules().add(rm);

            oop.getPreRequisitesModules().add(pf);

            concurrency.getPreRequisitesModules().add(oop);
            security.getPreRequisitesModules().add(oop);

            List.of(os, pf, rm, rdbms, oop, concurrency, security)
                            .forEach(em::persist);

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

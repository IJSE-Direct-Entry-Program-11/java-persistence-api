package lk.ijse.dep11.jpa.rel;

import lk.ijse.dep11.jpa.rel.entity.Employee2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class OneToOneUnaryDemo1 {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {

            Employee2 kasun = new Employee2("E001", "Kasun", "077-1234567");
            Employee2 nuwan = new Employee2("E002", "Nuwan", "078-1234567");
            Employee2 ruwan = new Employee2("E003", "Ruwan", "075-1234567");
            Employee2 supun = new Employee2("E004", "Supun", "070-1234567");
            Employee2 hansi = new Employee2("E005", "Hansi", "011-1234567");
            Employee2 piumi = new Employee2("E006", "Piumi", "055-1234567");
            Employee2 sadani = new Employee2("E007", "Saduni", "033-1234567");

            nuwan.setMarried(hansi);
            sadani.setMarried(ruwan);

            List.of(kasun, nuwan, ruwan, supun, hansi, piumi, sadani).forEach(em::persist);

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

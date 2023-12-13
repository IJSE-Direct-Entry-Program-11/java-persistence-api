package lk.ijse.dep11.jpa;

import lk.ijse.dep11.jpa.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HelloJPA {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("dep11");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Customer customer = new Customer(1, "Kasun", "Galle");
        em.persist(customer);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}

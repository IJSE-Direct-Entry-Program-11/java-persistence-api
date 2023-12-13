package lk.ijse.dep11.nh;

import lk.ijse.dep11.nh.db.HibernateUtil;
import lk.ijse.dep11.nh.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class UpdateDemo1 {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        try (Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                Customer customer = session.get(Customer.class, 2);
                System.out.println(customer);
                System.out.println("Is customer inside the context? "+
                        session.contains(customer));
                session.evict(customer);
                System.out.println("Is customer inside the context? "+
                        session.contains(customer));
                Customer sameCustomer = session
                        .get(Customer.class, 2);

                session.update(customer);
                System.out.println("Is customer inside the context? "+
                        session.contains(customer));

                tx.commit();
            }catch (Throwable t){
                tx.rollback();
                throw t;
            }
        }
    }
}

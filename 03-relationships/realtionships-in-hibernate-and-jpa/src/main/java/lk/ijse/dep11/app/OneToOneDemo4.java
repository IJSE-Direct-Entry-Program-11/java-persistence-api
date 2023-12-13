package lk.ijse.dep11.app;

import lk.ijse.dep11.app.db.HibernateUtil;
import lk.ijse.dep11.app.entity.Employee;
import lk.ijse.dep11.app.entity.Spouse;
import lk.ijse.dep11.app.entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OneToOneDemo4 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                Employee thisara = session.get(Employee.class, 1);
                System.out.println(thisara.getVehicle());

                Employee shehan = session.get(Employee.class, 2);
                System.out.println(shehan.getVehicle());

//                Vehicle ferari = new Vehicle("XYZ-123456", "Ferari", thisara);
//                session.save(ferari);

                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                throw t;
            }
        }
    }
}

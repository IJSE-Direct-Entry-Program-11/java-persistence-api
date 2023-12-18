package lk.ijse.dep11.app;

import lk.ijse.dep11.app.db.HibernateUtil;
import lk.ijse.dep11.app.entity.Employee2;
import lk.ijse.dep11.app.entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class OneToOneDemo2 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                Employee2 kasun = session.get(Employee2.class, "E001");
                Employee2 nuwan = session.get(Employee2.class, "E002");

                System.out.println(kasun.getVehicle());
                System.out.println(nuwan.getVehicle());

//                Vehicle prius = session.get(Vehicle.class, "V001");
//                Vehicle vitz = session.get(Vehicle.class, "V002");

                /* Add */
//                prius.setEmployee(kasun);
//                vitz.setEmployee(nuwan);

                /* Delete */
//                prius.setEmployee(null);
                //System.out.println(prius.getEmployee());

                tx.commit();
            }catch (Throwable t){
                tx.rollback();
                throw t;
            }
        }
    }
}

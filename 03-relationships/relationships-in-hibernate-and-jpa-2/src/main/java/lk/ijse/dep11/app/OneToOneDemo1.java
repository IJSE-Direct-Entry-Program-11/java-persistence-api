package lk.ijse.dep11.app;

import lk.ijse.dep11.app.db.HibernateUtil;
import lk.ijse.dep11.app.entity.Employee2;
import lk.ijse.dep11.app.entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class OneToOneDemo1 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                Employee2 e001 = new Employee2("E001", "Kasun", "077-1234567");
                Employee2 e002 = new Employee2("E002", "Nuwan", "078-1234567");
                Employee2 e003 = new Employee2("E003", "Ruwan", "076-1234567");
                Employee2 e004 = new Employee2("E004", "Sampath", "071-1234567");

                Vehicle prius = new Vehicle("V001", "Prius");
                Vehicle vitz = new Vehicle("V002", "Vitz");
                Vehicle bicycle = new Vehicle("V003", "Bicycle");

                List.of(e001, e002, e003, e004, prius, vitz, bicycle).forEach(session::save);

                tx.commit();
            }catch (Throwable t){
                tx.rollback();
                throw t;
            }
        }
    }
}

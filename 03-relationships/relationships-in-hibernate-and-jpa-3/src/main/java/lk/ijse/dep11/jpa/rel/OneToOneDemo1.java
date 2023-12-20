package lk.ijse.dep11.jpa.rel;

import lk.ijse.dep11.jpa.rel.db.HibernateUtil;
import lk.ijse.dep11.jpa.rel.entity.Employee;
import lk.ijse.dep11.jpa.rel.entity.EmployeeVehicle;
import lk.ijse.dep11.jpa.rel.entity.Vehicle;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class OneToOneDemo1 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                Employee e001 = new Employee("E001", "Kasun", "077-1234567");
                Employee e002 = new Employee("E002", "Nuwan", "078-1234567");
                Employee e003 = new Employee("E003", "Ruwan", "070-1234567");

                Vehicle prius = new Vehicle("V001", "Prius");
                Vehicle vitz = new Vehicle("V002", "Vitz");

                EmployeeVehicle ev01 = new EmployeeVehicle(e002, prius, "Thanura", new Date());

                List.of(e001, e002, e003, prius, vitz, ev01)
                                .forEach(session::save);

                tx.commit();
            }catch (Throwable t){
                tx.rollback();
                throw t;
            }
        }
    }
}

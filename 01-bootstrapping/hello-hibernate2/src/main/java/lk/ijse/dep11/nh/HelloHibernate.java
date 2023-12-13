package lk.ijse.dep11.nh;

import lk.ijse.dep11.nh.db.HibernateUtil;
import lk.ijse.dep11.nh.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class HelloHibernate {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        session.beginTransaction();

        Employee employee = new Employee(1, "Kasun Sampath", "077-1234567");
        session.save(employee);

        session.getTransaction().commit();
        session.close();
        sf.close();
    }
}

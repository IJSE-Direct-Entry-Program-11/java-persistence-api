package lk.ijse.dep11.app;

import lk.ijse.dep11.app.db.HibernateUtil;
import lk.ijse.dep11.app.entity.Employee;
import lk.ijse.dep11.app.entity.Spouse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class OneToOneDemo2 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                Employee thisara = session.get(Employee.class, 1);
                Employee shehan = session.get(Employee.class, 2);
                Spouse sukumali = session.get(Spouse.class, 1);

                //System.out.println(thisara);
                //System.out.println(shehan);
//                System.out.println(sukumali.getEmployee());
//                System.out.println(shehan.getSpouse());
//                System.out.println(thisara.getSpouse());
                thisara.setSpouse(sukumali);

                // sukumali.setEmployee(shehan);


                tx.commit();
            } catch (Throwable t) {
                tx.rollback();
                throw t;
            }
        }
    }
}

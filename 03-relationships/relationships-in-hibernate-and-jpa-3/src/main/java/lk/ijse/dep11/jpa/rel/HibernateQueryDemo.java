package lk.ijse.dep11.jpa.rel;

import lk.ijse.dep11.jpa.rel.db.HibernateUtil;
import lk.ijse.dep11.jpa.rel.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class HibernateQueryDemo {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                // HQL, JPQL, SQL
                Query<Student> query = session.createQuery("FROM lk.ijse.dep11.jpa.rel.entity.Student",
                        Student.class);

                List<Student> list = query.list();
                list.forEach(System.out::println);

                tx.commit();
            }catch (Throwable t){
                tx.rollback();
                throw t;
            }
        }
    }
}

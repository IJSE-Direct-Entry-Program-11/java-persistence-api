package lk.ijse.dep11.jpa.rel;

import lk.ijse.dep11.jpa.rel.db.HibernateUtil;
import lk.ijse.dep11.jpa.rel.entity.Course;
import lk.ijse.dep11.jpa.rel.entity.Enrollment;
import lk.ijse.dep11.jpa.rel.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class OneToManyDemo1 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                Course dep = new Course("DEP", "Direct Entry Program", "05 Months");
                Course gdse = new Course("GDSE", "Graduate Diploma in Software Engineering", "03 Years");
                Course cmjd = new Course("CMJD", "Comprehensive Master Java Developer", "06 Months");

                Student kasun = new Student("S001", "Kasun", "077-1234567");
                Student nuwan = new Student("S002", "Nuwan", "078-1234567");
                Student ruwan = new Student("S003", "Ruwan", "071-1234567");
                Student supun = new Student("S004", "Supun", "070-1234567");
                Student amith = new Student("S005", "Amith", "011-1234567");
                Student yasendra = new Student("S006", "Yasendra", "033-1234567");

                Enrollment e001 = new Enrollment(kasun, dep, "Maneesha", Date.valueOf(LocalDate.now()));
                Enrollment e002 = new Enrollment(nuwan, dep, "Maneesha", Date.valueOf(LocalDate.now()));
                Enrollment e003 = new Enrollment(ruwan, gdse, "Maneesha", Date.valueOf(LocalDate.now()));
                Enrollment e004 = new Enrollment(amith, gdse, "Maneesha", Date.valueOf(LocalDate.now()));

                List.of(dep, gdse, cmjd, kasun, nuwan, ruwan,supun, amith, yasendra, e001, e002, e003, e004)
                                .forEach(session::save);

                tx.commit();
            }catch (Throwable t){
                tx.rollback();
                throw t;
            }
        }
    }
}

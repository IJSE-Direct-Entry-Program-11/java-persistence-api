package lk.ijse.dep11.jpa.rel;

import lk.ijse.dep11.jpa.rel.db.HibernateUtil;
import lk.ijse.dep11.jpa.rel.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class OneToOneDemo2 {

    public static void main(String[] args) {
        try (SessionFactory sf = HibernateUtil.getSessionFactory();
             Session session = sf.openSession()) {
            Transaction tx = session.beginTransaction();
            try {

                Athlete thisara = new Athlete("A001", "Thisara", Date.valueOf(LocalDate.now()));
                Athlete pubudu = new Athlete("A002", "Pubudu", Date.valueOf(LocalDate.now()));
                Athlete ishan = new Athlete("A003", "Ishan", Date.valueOf(LocalDate.now()));

                PersonalTrainer shanika = new PersonalTrainer("P001", "Shanika", "BSc");
                PersonalTrainer piumi = new PersonalTrainer("P002", "Piumi", "MSc");

                AthleteTrainer at01 =
                        new AthleteTrainer(pubudu, shanika, Date.valueOf(LocalDate.now()), new BigDecimal("100000"));
//                AthleteTrainer at02 =
//                        new AthleteTrainer(pubudu, piumi, Date.valueOf(LocalDate.now()), new BigDecimal("100000"));

                List.of(thisara, pubudu, ishan, shanika, piumi, at01)
                                .forEach(session::save);

                tx.commit();
            }catch (Throwable t){
                tx.rollback();
                throw t;
            }
        }
    }
}

package lk.ijse.dep11.jpa.rel.db;

import lk.ijse.dep11.jpa.rel.entity.*;
import lk.ijse.dep11.jpa.rel.entity.Module;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure("/hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(standardRegistry)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Vehicle.class)
                .addAnnotatedClass(EmployeeVehicle.class)
                .addAnnotatedClass(Athlete.class)
                .addAnnotatedClass(PersonalTrainer.class)
                .addAnnotatedClass(AthleteTrainer.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Enrollment.class)
                .addAnnotatedClass(Counsellor.class)
                .addAnnotatedClass(Counselling.class)
                .addAnnotatedClass(Cart.class)
                .addAnnotatedClass(Item.class)
                .addAnnotatedClass(CartItem.class)
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(OrderGood.class)
                .addAnnotatedClass(OrderDetail.class)
                .addAnnotatedClass(Employee2.class)
                .addAnnotatedClass(Module.class)
                .addAnnotatedClass(Supplier.class)
                .addAnnotatedClass(Buyer.class)
                .addAnnotatedClass(LuxuryItem.class)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build();

        return metadata.getSessionFactoryBuilder()
                .build();
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}

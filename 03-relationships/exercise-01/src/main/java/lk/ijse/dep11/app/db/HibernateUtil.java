package lk.ijse.dep11.app.db;

import lk.ijse.dep11.app.entity.Batch;
import lk.ijse.dep11.app.entity.Contact;
import lk.ijse.dep11.app.entity.Module;
import lk.ijse.dep11.app.entity.Program;
import lk.ijse.dep11.app.entity.Student;
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
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Contact.class)
                .addAnnotatedClass(Program.class)
                .addAnnotatedClass(Batch.class)
                .addAnnotatedClass(Module.class)
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

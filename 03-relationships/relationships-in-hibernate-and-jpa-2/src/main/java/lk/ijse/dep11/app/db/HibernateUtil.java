package lk.ijse.dep11.app.db;

import lk.ijse.dep11.app.entity.Student;
import lk.ijse.dep11.app.entity.Teacher;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.*;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.spi.MetadataBuildingContext;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class HibernateUtil {

    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure("/hibernate.cfg.xml")
                .build();

        Metadata metadata = new MetadataSources(standardRegistry)
                .addAnnotatedClass(Student.class)
                .addAnnotatedClass(Teacher.class)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
//                .applyImplicitNamingStrategy(new ImplicitNamingStrategyJpaCompliantImpl(){
//                    @Override
//                    protected Identifier toIdentifier(String stringForm, MetadataBuildingContext buildingContext) {
//                        return new Identifier("orm_" + stringForm, false);
//                    }
//                })
//                .applyPhysicalNamingStrategy(new PhysicalNamingStrategyStandardImpl(){
//                    @Override
//                    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
//                        return new Identifier("dep_" + name, false);
//                    }
//                })
                .build();

        return metadata.getSessionFactoryBuilder()
                .build();
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}

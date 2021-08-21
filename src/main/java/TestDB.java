import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

public class TestDB {


    public static void main(String[] args) {

        System.out.println("sssssss");

        ServiceRegistry standardRegidtery = new StandardServiceRegistryBuilder()
                .configure().build();
        SessionFactory sessionFactory = new MetadataSources(standardRegidtery)
                .addAnnotatedClass(UserEntity.class).buildMetadata()
                .buildSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName("Esraa");
        userEntity.setLastName("Salem");
        session.persist(userEntity);

        userEntity.setFirstName("Esraa1");
        userEntity.setLastName("Salem1");
        session.persist(userEntity);

        UserEntity userEntity2 = new UserEntity();
        userEntity2.setFirstName("Esraa2");
        userEntity2.setLastName("Salem2");
        session.persist(userEntity2);

        session.getTransaction().commit();

        session.close();


    }
}

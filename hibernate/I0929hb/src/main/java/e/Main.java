package e;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;

public class Main {
    private static SessionFactory factory = new Configuration()
                                      .configure().buildSessionFactory();

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Address address = new Address(1, "ул. Койкого");
//            Address address = new Address(1);
            Student one = new Student("Койкого-5", address);
//            Student two = new Student("Койкого-4", address);
            session.save(one);
//            session.save(two);
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        factory.close();
    }
}

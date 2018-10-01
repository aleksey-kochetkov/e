package e;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class HbRepository implements Repository {
    private static final String NW = "hb.png";
    private static final SessionFactory factory = new Configuration()
                                      .configure().buildSessionFactory();

    @Override
    public void close() {
        factory.close();
    }

    @Override
    public void createFileEntity(FileEntity entity) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
            throw exception;
        } finally {
            session.close();
        }
    }

    @Override
    public void updateFileEntity(String old) {
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery(
                  "UPDATE FileEntity SET name = :new WHERE name = :old");
            query.setParameter("new", NW);
            query.setParameter("old", old);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
            throw exception;
        } finally {
            session.close();
        }
    }

    @Override
    public FileEntity find() {
        FileEntity result;
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            Query<FileEntity> query = session.createQuery(
                                   "FROM FileEntity WHERE name = :name");
            query.setParameter("name", NW);
            result = query.list().get(0);
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
            throw exception;
        } finally {
            session.close();
        }
        return result;
    }
}

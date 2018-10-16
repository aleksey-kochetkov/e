package e;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import java.util.List;

public class Repository {
    private static final SessionFactory FACTORY = new Configuration()
                                      .configure().buildSessionFactory();

    public void close() {
        FACTORY.close();
    }

    public void createStudent(Student student) {
        Session session = FACTORY.openSession();
        try {
            session.beginTransaction();
            session.persist(student);
            session.getTransaction().commit();
        } catch(Exception exception) {
            session.getTransaction().rollback();
            throw exception;
        } finally {
            session.close();
        }
    }

    public List<Student> findAllStudents() {
        Session session = FACTORY.openSession();
        try {
            session.beginTransaction();
            List<Student> result = session.createQuery(
                  "SELECT new Student(s.surname) FROM Student s").list();
            session.getTransaction().commit();
            return result;
        } catch (Exception exception) {
            session.getTransaction().rollback();
            throw exception;
        } finally {
            session.close();
        }
    }

    public List<Result> findCount() {
        Session session = FACTORY.openSession();
        try {
            session.beginTransaction();
            List<Result> result = session.createQuery(
                    "SELECT new e.Result(count(*)) FROM Student").list();
            session.getTransaction().commit();
            return result;
        } catch (Exception exception) {
            session.getTransaction().rollback();
            throw exception;
        } finally {
            session.close();
        }
    }
}

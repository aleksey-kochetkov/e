package e;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import java.util.List;

public class Repository {
    private static final SessionFactory FACTORY =
                   new Configuration().configure().buildSessionFactory();

    public void close() {
        FACTORY.close();
    }

    public List<BillingDetail> findAllBillingDetails() {
        Session session = FACTORY.openSession();
        try {
            session.beginTransaction();
            List<BillingDetail> result =
                        session.createQuery("FROM e.BillingDetail").list();
            session.getTransaction().commit();
            return result;
        } catch (Exception exception) {
            session.getTransaction().rollback();
            throw exception;
        } finally {
            session.close();
        }
    }

    public void createCreditCard(CreditCard card) {
        Session session = FACTORY.openSession();
        try {
            session.beginTransaction();
            session.persist(card);
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
            throw exception;
        } finally {
            session.close();
        }
    }

    public void createBankAccount(BankAccount account) {
        Session session = FACTORY.openSession();
        try {
            session.beginTransaction();
            session.persist(account);
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
            throw exception;
        } finally {
            session.close();
        }
    }
}

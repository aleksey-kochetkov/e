package e;

import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;

public class Main {
    private static final SessionFactory factory = new Configuration()
                                      .configure().buildSessionFactory();

    public static void main(String[] args) {
        new Main().run();
        factory.close();
    }

    public void run() {
        List<Certificate> certificates = new ArrayList<>();
        certificates.add(new Certificate("AA"));
        certificates.add(new Certificate("AB"));
        certificates.add(new Certificate("AC"));
        int firstId = createEmployee("Луночарский", 3900, certificates);
        certificates = new ArrayList<>();
        certificates.add(new Certificate("BA"));
        certificates.add(new Certificate("BB"));
        int secondId = createEmployee("Каутский", 4000, certificates);
        listEmployees();
        updateEmployee(firstId, 4100);
        deleteEmployee(secondId);
        listEmployees();
    }

    private Integer createEmployee(
         String name, int salary, Collection<Certificate> certificates) {
        Session session = factory.openSession();
        try {
            Integer result;
            session.beginTransaction();
            result = (Integer)
                  session.save(new Employee(name, salary, certificates));
            session.getTransaction().commit();
            return result;
        } catch (Exception exception) {
            session.getTransaction().rollback();
            throw exception;
        } finally {
            session.close();
        }
    }

   public void listEmployees() {
      Session session = factory.openSession();
      try {
         session.beginTransaction();
         List<Employee> employees = session.createQuery("FROM Employee").list();
         for (Employee e : employees) {
            System.out.format("Name: %s Salary: %d%n", e.getName(), e.getSalary());
            for (Certificate c : e.getCertificates()) {
               System.out.format("Certificate: %s%n", c.getDescript());
            }
         }
         session.getTransaction().commit();
      } catch (Exception exception) {
         session.getTransaction().rollback();
         throw exception;
      } finally {
         session.close();
      }
   }

   public void updateEmployee(int id, int salary) {
      Session session = factory.openSession();
      try {
         session.beginTransaction();
         Employee employee = session.get(Employee.class, id);
         employee.setSalary(salary);
         session.update(employee);
         session.getTransaction().commit();
      } catch (Exception exception) {
         session.getTransaction().rollback();
         throw exception;
      } finally {
         session.close();
      }
   }

    public void deleteEmployee(int id){
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            session.delete(new Employee(id));
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
            throw exception;
        } finally {
            session.close();
        }
    }
}

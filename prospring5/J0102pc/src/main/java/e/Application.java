package e;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.SpringApplication;
import org.hibernate.exception.ConstraintViolationException;
import e.model.Account;
import e.service.AccountService;

/**
 * (@PersistenceContext) Использование EntityManager в репозитории на
 * примере вызова EntityManager-persist() в дополнение к CrudRepository.
 * СУБД - org.apache.derby.jdbc.EmbeddedDriver.
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                          SpringApplication.run(Application.class, args);
        AccountService service = context.getBean(AccountService.class);
        Account account = new Account("one");
        service.createAccount(account);
        try {
            service.createAccount(account);
        } catch (Exception exception) {
            System.out.format(
                 "cp0:%s, service.createAccount() with existing login%n",
                                         exception.getClass().getName());
        }
        context.close();
    }
}
package e;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.SpringApplication;

/**
 * Разные варианты wiring by constructor.
 * 1) this.fromWarehouse()
 * 2) public Transfer two(Warehouse fromWarehouse, ...
 * 3) @ComponentScan("e.model")
 */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                          SpringApplication.run(Application.class, args);
        System.out.println(context.getBean("one"));
        System.out.println(context.getBean("two"));
        System.out.println(context.getBean("three"));
        context.close();
    }
}

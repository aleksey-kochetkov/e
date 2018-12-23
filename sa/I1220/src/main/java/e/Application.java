package e;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import e.config.Config;
import e.model.Warehouse;

/**
 * Разные варианты wiring through constructor.
 * 1) this.fromWarehouse()
 * 2) public Transfer two(Warehouse fromWarehouse, ...
 * 3) @ComponentScan("e.model")
 */
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                    new AnnotationConfigApplicationContext(Config.class);
        System.out.println(context.getBean("one"));
        System.out.println(context.getBean("two"));
        System.out.println(context.getBean("three"));
        context.close();
    }
}

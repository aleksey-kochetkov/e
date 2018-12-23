package e;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.SpringApplication;
import e.model.Rider;

/** Multiple @Configuration */
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                          SpringApplication.run(Application.class, args);
        System.out.println(context.getBean("one", Rider.class));
        System.out.println(context.getBean("two", Rider.class));
        System.out.println(context.getBean("three", Rider.class));
        context.close();
    }
}
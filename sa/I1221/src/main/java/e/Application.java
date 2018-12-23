package e;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import e.config.Config;
import e.model.Rider;

/** Multiple @Configuration */
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                    new AnnotationConfigApplicationContext(Config.class);
        System.out.println(context.getBean("one", Rider.class));
        System.out.println(context.getBean("two", Rider.class));
        System.out.println(context.getBean("three", Rider.class));
        context.close();
    }
}
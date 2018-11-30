package e;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HibernateTemplateTest {
    @Test
    public void whenCreate() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                                                "hibernate-context.xml");
        HibernateStorage storage = context.getBean(
                                                 HibernateStorage.class);
        storage.clean();
        User user = storage.add(new User("hb", "Hb"));
        assertTrue(storage.findAll().contains(user));
    }
}

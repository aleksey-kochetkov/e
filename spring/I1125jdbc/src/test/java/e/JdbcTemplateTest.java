package e;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JdbcTemplateTest {
    @Test
    public void whenCreate() {
        ApplicationContext context =
                  new ClassPathXmlApplicationContext("jdbc-context.xml");
        JdbcStorage storage = context.getBean(JdbcStorage.class);
        storage.clean();
        User user = storage.add(new User("jdbc", "Jdbc"));
        assertTrue(storage.findAll().contains(user));
    }
}

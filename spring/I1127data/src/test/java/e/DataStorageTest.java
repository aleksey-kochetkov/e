package e;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataStorageTest {
    @Test
    public void whenCreate() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                                                     "data-context.xml");
        DataStorage storage = context.getBean(DataStorage.class);
        storage.deleteAll();
        User user = storage.save(new User("data", "Data"));
        assertThat(storage.findOne(user.getLogin()), is(user));
    }
}

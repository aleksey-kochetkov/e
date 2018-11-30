package e;

import org.springframework.stereotype.Repository;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class HibernateStorage {
    private final HibernateTemplate template;

    public HibernateStorage(HibernateTemplate template) {
        this.template = template;
    }

    @Transactional
    public User add(User user) {
        this.template.save(user);
        return user;
    }

    public List<User> findAll() {
        return (List<User>) this.template.find("FROM User");
    }

    @Transactional
    public void clean() {
        this.template.bulkUpdate("DELETE User");
    }
}

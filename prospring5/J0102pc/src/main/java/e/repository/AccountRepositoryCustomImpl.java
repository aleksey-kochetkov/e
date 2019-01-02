package e.repository;

import javax.persistence.PersistenceContext;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;

public class AccountRepositoryCustomImpl implements AccountRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void persist(Object object) {
        this.entityManager.persist(object);
    }
}

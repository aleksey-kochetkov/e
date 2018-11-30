package e;

import org.springframework.data.repository.CrudRepository;

public interface DataStorage extends CrudRepository<User, String> {
}

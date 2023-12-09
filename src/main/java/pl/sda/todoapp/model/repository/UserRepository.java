package pl.sda.todoapp.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.todoapp.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}

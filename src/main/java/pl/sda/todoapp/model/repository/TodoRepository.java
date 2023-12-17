package pl.sda.todoapp.model.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.sda.todoapp.model.Todo;
import pl.sda.todoapp.model.User;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Integer> {

    // findAll --> SELECT * FROM Todos
    Optional<Todo> findByName(String name);

    Optional<Todo> findByNameAndId(String name, int id);

    List<Todo> findAllByCreateDateAfterOrderByCreateDate(Date after);

    List<Todo> findAllByCreateDateBetween(Date first, Date second);

    List<Todo> findAll();

    List<Todo> findAllByCreatedBy(User user);

    @Query("SELECT t FROM Todo t WHERE t.id = ?1 OR t.name = ?2")
    Todo getSomeVeryExtraordinaryQuery(int id, String name);
}

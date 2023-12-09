package pl.sda.todoapp.controller;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.sda.todoapp.model.Todo;
import pl.sda.todoapp.model.repository.TodoRepository;

import java.util.Calendar;
import java.util.Date;

@Component
public class DataLoader implements ApplicationRunner {

    private final TodoRepository todoRepository;

    public DataLoader(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 5);

        for (int i = 1; i <= 20; i++) {
            Todo todo = new Todo();
            todo.setName("Todo task number " + i);
            todo.setDescription("Todo task number " + i + " description");
            todo.setCreatedBy("John Doe");
            todo.setValidDate(c.getTime());

            todoRepository.save(todo);
        }
    }
}

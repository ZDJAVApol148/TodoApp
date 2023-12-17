package pl.sda.todoapp.controller;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.sda.todoapp.model.Todo;
import pl.sda.todoapp.model.User;
import pl.sda.todoapp.model.repository.TodoRepository;
import pl.sda.todoapp.model.repository.UserRepository;

import java.util.Calendar;
import java.util.Date;

@Component
public class DataLoader implements ApplicationRunner {

    private final TodoRepository todoRepository;

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public DataLoader(TodoRepository todoRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User jan = new User();
        jan.setUsername("jan");
        jan.setPassword(passwordEncoder.encode("jan"));
        jan.setEmail("jan@op.pl");
        jan.setFirstName("Jan");
        jan.setLastName("Nowak");

        userRepository.save(jan);

        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, 5);

        for (int i = 1; i <= 20; i++) {
            Todo todo = new Todo();
            todo.setName("Todo task number " + i);
            todo.setDescription("Todo task number " + i + " description");
            todo.setCreatedBy(jan);
            todo.setValidDate(c.getTime());

            todoRepository.save(todo);
        }
    }
}

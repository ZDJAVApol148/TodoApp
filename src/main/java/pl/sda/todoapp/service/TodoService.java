package pl.sda.todoapp.service;

import org.springframework.stereotype.Service;
import pl.sda.todoapp.model.Todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {

    public List<Todo> getList() {

        List<Todo> result = new ArrayList<>();

        for (int i = 1; i <= 20; i++) {
            result.add(getById(i));
        }

        return result;
    }

    public Todo getById(int id) {
        Todo todo = new Todo();

        todo.setId(id);
        todo.setDescription("Learn Spring");
        todo.setName("Learn Spring");
        todo.setCreateDate(new Date());
        todo.setUpdateDate(new Date());
        todo.setValidDate(new Date());
        todo.setCreatedBy("Janusz Kowalski");

        return todo;
    }

    public Todo saveOrUpdate(Todo todo) {
        if (todo.getId() == 0) {
            // create
            // persistence
        }
        else {
            // update
            Todo savedTodo = getById(todo.getId());
            savedTodo.setName(todo.getName());
            // persistence
        }

        return todo;
    }

}

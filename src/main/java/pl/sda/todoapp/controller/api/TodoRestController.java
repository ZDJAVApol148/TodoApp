package pl.sda.todoapp.controller.api;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.sda.todoapp.model.dto.TodoDto;
import pl.sda.todoapp.service.TodoService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoRestController {

    private final TodoService todoService;

    public TodoRestController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/api/todo")
    public List<TodoDto> getList() {
        List<TodoDto> todos = todoService.getList();

        return todos;
    }

    @PostMapping("/api/todo")
    public void create(@RequestBody TodoDto todo) {
        todoService.saveOrUpdate(todo);
    }
}

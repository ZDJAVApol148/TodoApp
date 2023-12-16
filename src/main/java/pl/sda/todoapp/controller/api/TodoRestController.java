package pl.sda.todoapp.controller.api;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.todoapp.model.dto.TodoDto;
import pl.sda.todoapp.service.TodoService;

import java.util.List;

@RestController
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
    public ResponseEntity<String> create(@RequestBody TodoDto todo) {
        todoService.saveOrUpdate(todo);

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body("OK");
    }
}

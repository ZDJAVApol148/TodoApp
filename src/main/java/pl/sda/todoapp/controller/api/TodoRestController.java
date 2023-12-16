package pl.sda.todoapp.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.todoapp.model.dto.TodoDto;
import pl.sda.todoapp.service.TodoService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200") // CORS
public class TodoRestController {

    private final TodoService todoService;

    public TodoRestController(TodoService todoService) {
        this.todoService = todoService;
    }

    @Operation(
            summary = "Gets all todos",
            description = "gets all todos for logged in user"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "successful operation")
            }
    )
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

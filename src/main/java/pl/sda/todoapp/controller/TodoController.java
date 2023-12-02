package pl.sda.todoapp.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.todoapp.model.Todo;
import pl.sda.todoapp.service.TodoService;

import java.util.List;

@Controller
@Slf4j
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    // GET list of todos
    @GetMapping("/todo")
    public String getList(Model model) {
        List<Todo> todos = todoService.getList();

        model.addAttribute("todoList", todos);

        return "todolist";
    }

    // GET todo by id (idempotence)
    @GetMapping("/todo/{id}")
    public String getById(@PathVariable int id, Model model) {
        Todo todo = todoService.getById(id);

        model.addAttribute("todo", todo);

        return "todo";
    }

    @GetMapping("/todo/new")
    public String create(Model model) {
        model.addAttribute("todo", new Todo());
        return "create";
    }

    // POST todo
    @PostMapping("/todo")
    public String create(Todo todo) {

        // TODO... Business logic

        return "redirect:/todo";
    }

    @GetMapping("/todo/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        Todo todo = todoService.getById(id);

        model.addAttribute("todo", todo);

        return "create";
    }

    // PUT todo
    public String update(Object todo) {
        return null;
    }

}

package pl.sda.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TodoController {

    // GET list of todos
    @GetMapping("/todo")
    public String getList() {
        return "todolist";
    }

    // GET todo by id
    @GetMapping("/todo/{id}")
    public String getById(@PathVariable int id) {
        return "todo";
    }

    // POST todo
    public String create(Object todo) {
        return null;
    }

    // PUT todo
    public String update(Object todo) {
        return null;
    }

}

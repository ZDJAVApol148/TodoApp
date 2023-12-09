package pl.sda.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.todoapp.model.dto.CreateUserDto;

@Controller
public class UserController {

    // GET /user/register
    @GetMapping("/user/register")
    public String register(Model model) {
        model.addAttribute("user", new CreateUserDto());
        return "register";
    }

    // POST /user/register
}

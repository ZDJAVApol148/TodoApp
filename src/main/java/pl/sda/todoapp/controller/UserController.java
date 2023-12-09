package pl.sda.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.todoapp.model.dto.CreateUserDto;
import pl.sda.todoapp.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // GET /user/register
    @GetMapping("/user/register")
    public String register(Model model) {
        model.addAttribute("user", new CreateUserDto());
        return "register";
    }

    // POST /user/register
    @PostMapping("/user/register")
    public String register(CreateUserDto userDto) {
        userService.register(userDto);
        return "redirect:/login";
    }
}

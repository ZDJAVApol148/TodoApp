package pl.sda.todoapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeApiController {

    @GetMapping("/api")
    public Account home() {
        return new Account("0001010101", "Jan Nowak");
    }
}

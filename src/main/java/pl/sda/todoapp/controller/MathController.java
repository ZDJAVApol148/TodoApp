package pl.sda.todoapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.todoapp.service.MathService;

@RestController
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    // GET /api/math/add
    @GetMapping("/api/math/add")
    public int add() {
        return mathService.add(5, 2);
    }

    // GET /api/math/subtract
    @GetMapping("/api/math/subtract")
    public int subtract() {
        return mathService.subtract(5, 2);
    }
}

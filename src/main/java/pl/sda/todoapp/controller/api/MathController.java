package pl.sda.todoapp.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.sda.todoapp.service.MathService;

@RestController
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    // GET /api/math/add/{param1}/{param2}
    @GetMapping("/api/math/add/{param1}/{param2}")
    public int add(
            @PathVariable(name = "param1") int a,
            @PathVariable(name = "param2") int b) {
        return mathService.add(a, b);
    }

    // GET /api/math/subtract/{param1}/{param2}
    @GetMapping("/api/math/subtract/{param1}/{param2}")
    public int subtract(
            @PathVariable(name = "param1") int a,
            @PathVariable(name = "param2") int b) {
        return mathService.subtract(a, b);
    }
}

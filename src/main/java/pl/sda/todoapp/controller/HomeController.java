package pl.sda.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    @ResponseBody
    public String helloWorld() {
        return "Hello, World!";
    }

    @GetMapping("/html")
    public String helloWorldFromHtml() {
        return "helloworld";
    }

    // GET todo/{id}
    // http://localhost:8080/api/math/add
    // GET/POST/PUT/PATCH/DELETE http://localhost:8080/api/math/add/5/2
    // GET/POST/PUT/PATCH/DELETE http://localhost:8080/api/math/add?a=5&b=2
    // POST/PUT/PATCH http://localhost:8080/api/math/add
    // body: { a = b, b = 2 }
    // GET todo
    // POST todo
    // PUT/POST todo/{id}
}

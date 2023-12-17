package pl.sda.todoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/home")
    @ResponseBody
    public String helloWorld() {
        return "Hello, World!";
    }

    // /html endpoint handle in WebConfig
//    @GetMapping("/html")
//    public String helloWorldFromHtml() {
//        return "helloworld";
//    }
}

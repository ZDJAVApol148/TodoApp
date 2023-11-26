package pl.sda.todoapp.controller;

import org.springframework.web.bind.annotation.*;
import pl.sda.todoapp.Account;

@RestController
public class HomeApiController {

    /*@GetMapping("/api")
    public Account home() {
        return new Account("0001010101", "Jan Nowak");
    }*/


    // GET /api/{number}/{name}
    @GetMapping("/api/variables/{number}/{name}")
    public Account homeWithPathVariables(
            @PathVariable(name = "number") String number,
            @PathVariable(name = "name") String name) {
        return new Account(number, name);
    }

    // GET /api?number={number}&name={name}
    // TODO: optional params
    @GetMapping("/api/params")
    public Account homeWithRequestParams(
            @RequestParam(name = "number") String number,
            @RequestParam(name = "name") String name) {
        return new Account(number, name);
    }

    // { "name": "Jan Nowak", "number": "123456" }
    // { "tab": [{ "param1": 0, "param2": "String", "date": "2023-11-11" },{}]
    @PostMapping("/api/body")
    public Account homeWithBody(@RequestBody Account account) {
        return account;
    }
}

package pl.sda.todoapp.controller;

import org.springframework.web.bind.annotation.*;
import pl.sda.todoapp.model.Logger;

@RestController
public class PetController {

    // new PetController(new Logger())

    private final Logger logger;

    public PetController(Logger logger) {
        this.logger = logger;
    }

    // create
    // POST localhost:8080/api/pet
    @PostMapping("/api/pet")
    public String create() {
        logger.log("post");
        return "post";
    }

    // get
    // GET localhost:8080/api/pet
    // idempotence
    @GetMapping("/api/pet")
    public String get() {
        logger.log("get");
        return "get";
    }

    // delete
    @DeleteMapping("/api/pet")
    public String delete() {
        return "delete";
    }

    // update (property)
    @PatchMapping("/api/pet")
    public String patch() {
        return "patch";
    }

    // update (object)
    @PutMapping("/api/pet")
    public String put() {
        return "put";
    }
}

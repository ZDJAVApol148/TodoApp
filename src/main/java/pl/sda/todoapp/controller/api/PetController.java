package pl.sda.todoapp.controller.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.sda.todoapp.controller.PetControllerInterface;
import pl.sda.todoapp.model.Logger;

@RestController
public class PetController implements PetControllerInterface {

    // new PetController(new Logger())

    private final Logger logger;

    public PetController(Logger logger) {
        this.logger = logger;
    }

    // create
    // POST localhost:8080/api/pet
    // RESPONSE CODE: 201
    @PostMapping("/api/pet")
    public ResponseEntity<String> create() {
        logger.log("post");

        // call external service

        return ResponseEntity
                .status(HttpStatusCode.valueOf(201))
                .body("post");
    }

    // get
    // GET localhost:8080/api/pet
    // RESPONSE CODE: 200
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

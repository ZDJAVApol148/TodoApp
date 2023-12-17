package pl.sda.todoapp.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;

public interface PetControllerInterface {

    @Operation(
            summary = "Creates a new pet",
            description = "Creates a new pet based on given model"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "200", description = "success"),
                    @ApiResponse(responseCode = "401", description = "unauthorized"),
                    @ApiResponse(responseCode = "422", description = "bad request")
            }
    )
    ResponseEntity<String> create();
}

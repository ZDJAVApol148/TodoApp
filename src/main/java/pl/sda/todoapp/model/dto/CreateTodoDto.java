package pl.sda.todoapp.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CreateTodoDto {

    private String name;
    private String description;
    private String createdBy;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date validDate;
}

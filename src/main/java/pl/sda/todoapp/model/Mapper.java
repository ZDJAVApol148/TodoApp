package pl.sda.todoapp.model;

import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public String toUpper(String message) {
        return message.toUpperCase();
    }
}

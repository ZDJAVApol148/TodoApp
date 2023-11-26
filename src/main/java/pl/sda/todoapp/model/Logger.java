package pl.sda.todoapp.model;

import org.springframework.stereotype.Component;

@Component
public class Logger {

    private Mapper mapper;

    public Logger(Mapper mapper) {
        this.mapper = mapper;
    }

    public void log(String message) {
        System.out.println(message);
        System.out.println(mapper.toUpper(message));
    }
}

//

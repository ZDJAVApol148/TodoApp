package pl.sda.todoapp.model;

import pl.sda.todoapp.model.dto.TodoDto;

import java.util.ArrayList;
import java.util.List;

public class TodoMapper {

    public static TodoDto map(Todo todo) {
        TodoDto dto = new TodoDto();
        dto.setId(todo.getId());
        dto.setName(todo.getName());
        dto.setDescription(todo.getDescription());
        dto.setValidDate(todo.getValidDate());
        dto.setCreatedBy(todo.getCreatedBy());

        return dto;
    }

    public static Todo map(TodoDto dto) {
        Todo todo = new Todo();
        todo.setId(dto.getId());
        todo.setName(dto.getName());
        todo.setDescription(dto.getDescription());
        todo.setValidDate(dto.getValidDate());
        todo.setCreatedBy(dto.getCreatedBy());

        return todo;
    }

    public static List<TodoDto> mapEntityListToDtoList(List<Todo> todos) {
        List<TodoDto> result = new ArrayList<>();

        for (Todo todo: todos) {
            result.add(map(todo));
        }

        return result;
    }

    public static List<Todo> mapDtoListToEntityList(List<TodoDto> dtos) {
        List<Todo> result = new ArrayList<>();

        for (TodoDto dto: dtos) {
            result.add(map(dto));
        }

        return result;
    }
}

package pl.sda.todoapp.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import pl.sda.todoapp.model.Todo;
import pl.sda.todoapp.model.TodoMapper;
import pl.sda.todoapp.model.dto.TodoDto;
import pl.sda.todoapp.model.repository.TodoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<TodoDto> getList() {
        // 1) get from db
        List<Todo> todos = todoRepository.findAll();

        // 2) map entities to dtos
        List<TodoDto> dtos = TodoMapper.mapEntityListToDtoList(todos);

        // 3) do some business logic

        // 4) return result
        return dtos;
    }

    public TodoDto getById(int id) {
        Optional<Todo> todoOptional = todoRepository.findById(id);
        if (todoOptional.isPresent()) {
            TodoDto dto = TodoMapper.map(todoOptional.get());
            return dto;
        }

        throw new EntityNotFoundException();
    }

    public void saveOrUpdate(TodoDto dto) {
        // 1) validate

        // 2) prepare entity
        Todo todo = TodoMapper.map(dto);

        // 3) do some technical work
        /* // 3a) create and update date
        todo.setUpdateDate(new Date());
        if (dto.getId() > 0) {
            // update
            // do nothing
            Optional<Todo> saved = todoRepository.findById(dto.getId());
            if (saved.isPresent()) {
                todo.setCreateDate(saved.get().getCreateDate());
            }
            else {
                throw new EntityNotFoundException();
            }
        } else {
            // create
            todo.setCreateDate(new Date());
        }*/

        todoRepository.save(todo);
    }
}

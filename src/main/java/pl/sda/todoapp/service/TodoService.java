package pl.sda.todoapp.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import pl.sda.todoapp.model.Todo;
import pl.sda.todoapp.model.TodoMapper;
import pl.sda.todoapp.model.User;
import pl.sda.todoapp.model.dto.CustomUserDetails;
import pl.sda.todoapp.model.dto.TodoDto;
import pl.sda.todoapp.model.repository.TodoRepository;
import pl.sda.todoapp.model.repository.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    private final UserRepository userRepository;

    public TodoService(TodoRepository todoRepository, UserRepository userRepository) {
        this.todoRepository = todoRepository;
        this.userRepository = userRepository;
    }

    public List<TodoDto> getList() {

        CustomUserDetails userDetails = getCurrentUser();

        Optional<User> user = userRepository.findById(userDetails.getId());
        if (user.isEmpty()) {
            // TODO: throw and handle an exception
        }

        // 1) get from db
        List<Todo> todos = todoRepository.findAllByCreatedBy(user.get());

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

        CustomUserDetails userDetails = getCurrentUser();

        Optional<User> user = userRepository.findById(userDetails.getId());
        user.ifPresent(todo::setCreatedBy);

        // TODO: throw an exception - user not found

        todoRepository.save(todo);
    }

    private CustomUserDetails getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (CustomUserDetails) authentication.getPrincipal();
    }
}

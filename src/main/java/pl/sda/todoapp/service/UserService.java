package pl.sda.todoapp.service;

import org.springframework.stereotype.Service;
import pl.sda.todoapp.model.User;
import pl.sda.todoapp.model.dto.CreateUserDto;
import pl.sda.todoapp.model.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(CreateUserDto createUserDto) {
        User user = new User();
        user.setUsername(createUserDto.getUsername());
        user.setEmail(createUserDto.getEmail());
        user.setFirstName(createUserDto.getFirstName());
        user.setLastName(createUserDto.getLastName());
        user.setPassword(createUserDto.getPassword());

        userRepository.save(user);
    }
}

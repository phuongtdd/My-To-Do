package spring.todoapp.mapper;

import spring.todoapp.dto.request.UserRequestDTO;
import spring.todoapp.dto.response.UserResponseDTO;
import spring.todoapp.modal.User;

import java.util.stream.Collectors;

public class UserMapper {
    public static User toUser(UserRequestDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setFullName(dto.getFullName());
        return user;
    }

    public static UserResponseDTO toUserResponseDTO(User user) {
        UserResponseDTO dto = new UserResponseDTO();
        dto.setUsername(user.getUsername());
        dto.setFullName(user.getFullName());
        dto.setEmail(user.getEmail());
        dto.setUser_id(user.getUserId());
        if(user.getTasks() != null) {
            dto.setTasks(user.getTasks()
            .stream()
                    .map(TaskMapper::toTaskResponseDTO)
                    .collect(Collectors.toList()));
        }
        return dto;
    }
}

package spring.todoapp.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.todoapp.dto.response.ApiResponse;
import spring.todoapp.dto.request.UserRequestDTO;
import spring.todoapp.dto.response.UserResponseDTO;
import spring.todoapp.modal.User;
import spring.todoapp.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public ApiResponse<User> createUser(@RequestBody @Valid UserRequestDTO requestDTO) {
        ApiResponse<User> response = new ApiResponse<>();
        response.setResult(userService.createUser(requestDTO));
        return response;
    }

    @GetMapping("/users")
    public ApiResponse<List<UserResponseDTO>> getAllUsers() {
        ApiResponse<List<UserResponseDTO>> response = new ApiResponse<>();
        response.setResult(userService.findAll());
        return response;
    }

    @GetMapping("/user/{id}")
    public ApiResponse<UserResponseDTO> getUser(@PathVariable String id) {
        ApiResponse<UserResponseDTO> response = new ApiResponse<>();
        response.setResult(userService.findUserById(id));
        return response;
    }

    @PutMapping("/user/{id}")
    public ApiResponse<User> updateUser(@PathVariable String id, @RequestBody @Valid UserRequestDTO requestDTO) {
        ApiResponse<User> response = new ApiResponse<>();
        response.setResult(userService.updateUser(id, requestDTO));
        return response;
    }

    @DeleteMapping("/user/{id}")
    public ApiResponse<UserResponseDTO> deleteUser(@PathVariable String id) {
        ApiResponse<UserResponseDTO> response = new ApiResponse<>();
        response.setResult(userService.findUserById(id));
        response.setMessage("User deleted successfully");
        userService.deleteUser(id);
        return response;
    }
}

package spring.todoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.todoapp.dto.request.UserRequestDTO;
import spring.todoapp.dto.response.UserResponseDTO;
import spring.todoapp.exception.ApplicationException;
import spring.todoapp.exception.ErrorCode;
import spring.todoapp.mapper.UserMapper;
import spring.todoapp.modal.User;
import spring.todoapp.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public List<UserResponseDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toUserResponseDTO)
                .collect(Collectors.toList());
    }


    public User createUser(UserRequestDTO requestDTO) {
        requestDTO.setPassword(passwordEncoder.encode(requestDTO.getPassword()));
        User user = UserMapper.toUser(requestDTO);
        if (userRepository.existsByUsername(requestDTO.getUsername()))
            throw new ApplicationException(ErrorCode.USER_EXISTED);
        return userRepository.save(user);
    }

    public UserResponseDTO findUserById(String id) {
        return  UserMapper.toUserResponseDTO(userRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(ErrorCode.USER_NOT_EXISTED)));
    }

    public User updateUser(String id, UserRequestDTO requestDTO) {
        User user = userRepository.findById(id).orElse(null);
        user.setUsername(requestDTO.getUsername());
        user.setPassword(passwordEncoder.encode(requestDTO.getPassword()));
        user.setEmail(requestDTO.getEmail());
        user.setFullName(requestDTO.getFullName());
        return userRepository.save(user);
    }

    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}

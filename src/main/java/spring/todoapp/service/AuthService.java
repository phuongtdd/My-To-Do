package spring.todoapp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.todoapp.dto.request.AuthenticateRequestDTO;
import spring.todoapp.exception.ApplicationException;
import spring.todoapp.exception.ErrorCode;
import spring.todoapp.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    public boolean authenticate(AuthenticateRequestDTO authenticateRequestDTO) {
        var user = userRepository.findByUsernameOrEmail(authenticateRequestDTO.getUsername(), authenticateRequestDTO.getEmail())
                .orElseThrow(() -> new ApplicationException(ErrorCode.USER_NOT_EXISTED));
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(authenticateRequestDTO.getPassword(), user.getPassword());
    }

}

package spring.todoapp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.todoapp.dto.response.ApiResponse;
import spring.todoapp.dto.request.AuthenticateRequestDTO;
import spring.todoapp.dto.response.AuthenticateResponseDTO;
import spring.todoapp.service.AuthService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/auth/login")
    public ApiResponse<AuthenticateResponseDTO> login(@RequestBody AuthenticateRequestDTO authenticateRequestDTO) {
        boolean isAuthenticated = authService.authenticate(authenticateRequestDTO);

        return ApiResponse.<AuthenticateResponseDTO>builder()
                .result(AuthenticateResponseDTO.builder()
                        .isAuthenticated(isAuthenticated)
                        .build())
                .build();
    }



}

package spring.todoapp.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {

    @Size(min = 8 , max = 30, message = "USERNAME_SIZE")
    private String username;
    @Size(min = 8, message = "PASSWORD_SIZE")
    private String password;
    private String fullName;

    @Email(message = "INVALID_EMAIL")
    private String email;

    public UserRequestDTO() {
    }

    public UserRequestDTO(String username, String password, String fullName, String email) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

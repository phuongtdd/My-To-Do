package spring.todoapp.dto.response;

import java.util.List;

public class UserResponseDTO {

    private String user_id;
    private String username;
    private String fullName;
    private String email;
    private List<TaskResponseDTO> tasks;

    public UserResponseDTO() {
    }

    public UserResponseDTO(String user_id, String username, String fullName, String email, List<TaskResponseDTO> tasks) {
        this.user_id = user_id;
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.tasks = tasks;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public List<TaskResponseDTO> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskResponseDTO> tasks) {
        this.tasks = tasks;
    }
}

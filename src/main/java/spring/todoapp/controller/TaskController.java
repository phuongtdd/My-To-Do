package spring.todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.todoapp.dto.response.ApiResponse;
import spring.todoapp.dto.request.TaskRequestDTO;
import spring.todoapp.dto.response.TaskResponseDTO;
import spring.todoapp.modal.Task;
import spring.todoapp.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/tasks")
    public ApiResponse<List<TaskResponseDTO>> listAllTasks() {
        ApiResponse<List<TaskResponseDTO>> response = new ApiResponse<>();
        response.setResult(taskService.findAll());
        return response;
    }

    @PostMapping("/task")
    public ApiResponse<TaskResponseDTO> createTask(@RequestBody TaskRequestDTO taskRequestDTO) {
        ApiResponse<TaskResponseDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(taskService.createTask(taskRequestDTO));
        return apiResponse;
    }

    @GetMapping("/task/{id}")
    public ApiResponse<TaskResponseDTO> getTask(@PathVariable String id) {
        ApiResponse<TaskResponseDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(taskService.findTaskById(id));
        return apiResponse;
    }

    @PutMapping("/task/{id}")
    public ApiResponse<TaskResponseDTO> updateTask(@PathVariable String id, @RequestBody TaskRequestDTO taskRequestDTO) {
        ApiResponse<TaskResponseDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(taskService.updateTask(id, taskRequestDTO));
        return apiResponse;
    }

    @DeleteMapping("/task/{id}")
    public ApiResponse<TaskResponseDTO> deleteTask(@PathVariable String id) {
        ApiResponse<TaskResponseDTO> apiResponse = new ApiResponse<>();
        apiResponse.setResult(taskService.findTaskById(id));
        taskService.deleteTask(id);
        apiResponse.setMessage("Task deleted successfully");
        return apiResponse;
    }

}

package spring.todoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.todoapp.dto.request.TaskRequestDTO;
import spring.todoapp.dto.response.TaskResponseDTO;
import spring.todoapp.exception.ApplicationException;
import spring.todoapp.exception.ErrorCode;
import spring.todoapp.mapper.TaskMapper;
import spring.todoapp.mapper.UserMapper;
import spring.todoapp.modal.Task;
import spring.todoapp.modal.User;
import spring.todoapp.repository.LabelRepository;
import spring.todoapp.repository.TaskRepository;
import spring.todoapp.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LabelRepository labelRepository;


    public List<TaskResponseDTO> findAll() {
        return taskRepository.findAll()
                .stream()
                .map(TaskMapper::toTaskResponseDTO)
                .collect(Collectors.toList());
    }

    public TaskResponseDTO createTask(TaskRequestDTO taskRequestDTO) {
        User user = userRepository.findById(taskRequestDTO.getUserId())
                .orElseThrow(() -> new ApplicationException(ErrorCode.USER_NOT_EXISTED));
        Task task = TaskMapper.toTask(taskRequestDTO);
        if(taskRequestDTO.getLabelIds() != null && taskRequestDTO.getLabelIds().size() > 0) {
            task.setLabels(labelRepository.findAllById(taskRequestDTO.getLabelIds()));
        }
        task.setUser(user);
        task.setCreatedAt(LocalDateTime.now());
        return TaskMapper.toTaskResponseDTO(taskRepository.save(task));
    }

    public TaskResponseDTO findTaskById(String id) {
        return TaskMapper.toTaskResponseDTO(taskRepository.findById(id).get());
    }

    public TaskResponseDTO updateTask(String taskID, TaskRequestDTO taskRequestDTO) {
        Task task = taskRepository.findById(taskID)
                .orElseThrow( () -> new ApplicationException(ErrorCode.TASK_NOT_EXISTED));
        if(taskRequestDTO.getLabelIds() != null && taskRequestDTO.getLabelIds().size() > 0) {
            task.setLabels(labelRepository.findAllById(taskRequestDTO.getLabelIds()));
        }
            task.setTitle(taskRequestDTO.getTitle());
            task.setDescription(taskRequestDTO.getDescription());
            task.setPriority(taskRequestDTO.getPriority());
            task.setStatus(taskRequestDTO.getStatus());
            task.setDueDate(taskRequestDTO.getDueDate());
            task.setUpdatedAt(LocalDateTime.now());
        return TaskMapper.toTaskResponseDTO(taskRepository.save(task));
    }

    public void deleteTask(String taskID) {
        Task task = taskRepository.findById(taskID)
                .orElseThrow( () -> new ApplicationException(ErrorCode.TASK_NOT_EXISTED));
        taskRepository.delete(task);
    }
}

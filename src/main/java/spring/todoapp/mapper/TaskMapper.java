package spring.todoapp.mapper;

import spring.todoapp.dto.request.TaskRequestDTO;
import spring.todoapp.dto.response.TaskResponseDTO;
import spring.todoapp.modal.Task;

import java.util.stream.Collectors;

public class TaskMapper {
    public static TaskResponseDTO toTaskResponseDTO(Task task) {
        TaskResponseDTO taskResponseDTO = new TaskResponseDTO();
        taskResponseDTO.setTaskId(task.getTaskId());
        taskResponseDTO.setTitle(task.getTitle());
        taskResponseDTO.setDescription(task.getDescription());
        taskResponseDTO.setStatus(task.getStatus());
        taskResponseDTO.setPriority(task.getPriority());
        taskResponseDTO.setDueDate(task.getDueDate());
        taskResponseDTO.setCreatedAt(task.getCreatedAt());
        taskResponseDTO.setUpdatedAt(task.getUpdatedAt());
        if(task.getUser() != null) {
            taskResponseDTO.setUserId(task.getUser().getUserId());
            taskResponseDTO.setUsername(task.getUser().getUsername());
        }

        if(task.getLabels() != null) {
            taskResponseDTO.setLabels(task.getLabels()
            .stream()
                    .map(LabelMapper::toLabelResponseDTO)
                    .collect(Collectors.toList()));
        }
        return taskResponseDTO;

    }

    public static Task toTask(TaskRequestDTO dto) {
        Task task = new Task();
        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(dto.getStatus());
        task.setPriority(dto.getPriority());
        task.setDueDate(dto.getDueDate());
        return task;
    }
}

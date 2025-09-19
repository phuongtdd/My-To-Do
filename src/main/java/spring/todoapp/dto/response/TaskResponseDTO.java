package spring.todoapp.dto.response;

import lombok.*;
import spring.todoapp.modal.enums.TaskPriority;
import spring.todoapp.modal.enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskResponseDTO {
    private String taskId;
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private LocalDateTime dueDate;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<LabelResponseDTO> labels;
    private String userId;
    private String username;
}

package spring.todoapp.dto.request;

import lombok.*;
import spring.todoapp.modal.enums.TaskPriority;
import spring.todoapp.modal.enums.TaskStatus;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TaskRequestDTO {
    private String userId;
    private String title;
    private String description;
    private TaskStatus status;
    private TaskPriority priority;
    private LocalDateTime dueDate;
    private List<String> labelIds;
}

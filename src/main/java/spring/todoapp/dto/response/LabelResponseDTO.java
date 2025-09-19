package spring.todoapp.dto.response;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LabelResponseDTO {
    private String labelId;
    private String labelName;
}

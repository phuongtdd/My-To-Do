package spring.todoapp.mapper;

import spring.todoapp.dto.request.LabelRequestDTO;
import spring.todoapp.dto.response.LabelResponseDTO;
import spring.todoapp.modal.Label;

public class LabelMapper {

    public static LabelResponseDTO toLabelResponseDTO(Label label) {
        LabelResponseDTO labelResponseDTO = new LabelResponseDTO();
        labelResponseDTO.setLabelId(label.getLabelId());
        labelResponseDTO.setLabelName(label.getLabelName());
        return labelResponseDTO;
    }

    public static Label toLabel(LabelRequestDTO labelRequestDTO) {
        Label label = new Label();
        label.setLabelName(labelRequestDTO.getLabelName());
        return label;
    }
}

package spring.todoapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.todoapp.dto.request.LabelRequestDTO;
import spring.todoapp.dto.response.ApiResponse;
import spring.todoapp.dto.response.LabelResponseDTO;
import spring.todoapp.mapper.LabelMapper;
import spring.todoapp.modal.Label;
import spring.todoapp.repository.LabelRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LabelService {

    @Autowired
    private LabelRepository labelRepository;

    public List<LabelResponseDTO> getAllLabels() {
        return labelRepository.findAll()
                .stream()
                .map(LabelMapper::toLabelResponseDTO)
                .collect(Collectors.toList());
    }

    public LabelResponseDTO createLabel(LabelRequestDTO labelRequestDTO) {
        return LabelMapper.toLabelResponseDTO(labelRepository.save(LabelMapper.toLabel(labelRequestDTO)));
    }

    public LabelResponseDTO getLabelById(String id) {
        return LabelMapper.toLabelResponseDTO(labelRepository.findById(id).get());
    }

    public LabelResponseDTO updateLabel(String id, LabelRequestDTO labelRequestDTO) {
        Label label = labelRepository.findById(id).get();
        label.setLabelName(labelRequestDTO.getLabelName());
        return LabelMapper.toLabelResponseDTO(labelRepository.save(label));
    }

    public void deleteLabel(String id) {}
}

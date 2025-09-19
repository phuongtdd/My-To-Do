package spring.todoapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.todoapp.dto.request.LabelRequestDTO;
import spring.todoapp.dto.response.ApiResponse;
import spring.todoapp.dto.response.LabelResponseDTO;
import spring.todoapp.service.LabelService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LabelController {

    @Autowired
    private LabelService labelService;

    @GetMapping("/labels")
    public ApiResponse<List<LabelResponseDTO>> listAllLabels() {
        ApiResponse<List<LabelResponseDTO>> response = new ApiResponse<>();
        response.setResult(labelService.getAllLabels());
        return response;
    }

    @PostMapping("/label")
    public ApiResponse<LabelResponseDTO> createLabel(@RequestBody LabelRequestDTO labelRequestDTO) {
        ApiResponse<LabelResponseDTO> response = new ApiResponse<>();
        response.setResult(labelService.createLabel(labelRequestDTO));
        return response;
    }

    @GetMapping("/label/{id}")
    public ApiResponse<LabelResponseDTO> getLabel(@PathVariable String id) {
        ApiResponse<LabelResponseDTO> response = new ApiResponse<>();
        response.setResult(labelService.getLabelById(id));
        return response;
    }

    @PutMapping("/label/{id}")
    public ApiResponse<LabelResponseDTO> updateLabel(@PathVariable String id, @RequestBody LabelRequestDTO labelRequestDTO) {
        ApiResponse<LabelResponseDTO> response = new ApiResponse<>();
        response.setResult(labelService.updateLabel(id, labelRequestDTO));
        return response;
    }

    @DeleteMapping("/label/{id}")
    public ApiResponse<LabelResponseDTO> deleteLabel(@PathVariable String id) {
        ApiResponse<LabelResponseDTO> response = new ApiResponse<>();
        response.setResult(labelService.getLabelById(id));
        response.setMessage("Successfully deleted label");
        labelService.deleteLabel(id);
        return response;
    }
}

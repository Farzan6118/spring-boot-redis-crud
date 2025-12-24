package com.example.data.Controller;

import com.example.data.Controller.dto.request.ProfessorRequestDto;
import com.example.data.Controller.dto.response.ProfessorResponseDto;
import com.example.data.service.ProfessorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping(value = "api/v1/professor")
@RequiredArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @GetMapping("list")
    public ResponseEntity<List<ProfessorResponseDto>> getAll() {
        return ResponseEntity.ok(professorService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProfessorResponseDto> getById(
            @PathVariable Long id) {
        return ResponseEntity.ok(professorService.getById(id));
    }

    @GetMapping("count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(professorService.countActive());
    }

    @PostMapping
    public ResponseEntity<ProfessorResponseDto> create(
            @Valid @RequestBody ProfessorRequestDto requestDto) {
        return ResponseEntity.ok(professorService.create(requestDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<ProfessorResponseDto> updateById(
            @Valid @RequestBody ProfessorRequestDto requestDto,
            @PathVariable Long id) {
        return ResponseEntity.ok(professorService.update(id, requestDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable Long id) {
        professorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

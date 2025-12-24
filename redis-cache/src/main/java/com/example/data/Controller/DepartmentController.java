package com.example.data.Controller;

import com.example.data.Controller.dto.request.DepartmentRequestDto;
import com.example.data.Controller.dto.response.DepartmentResponseDto;
import com.example.data.service.DepartmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping(value = "api/v1/department")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping("list")
    public ResponseEntity<List<DepartmentResponseDto>> getAll() {
        return ResponseEntity.ok(departmentService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<DepartmentResponseDto> getById(
            @PathVariable Long id) {
        return ResponseEntity.ok(departmentService.getById(id));
    }

    @GetMapping("count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(departmentService.countActive());
    }

    @PostMapping
    public ResponseEntity<DepartmentResponseDto> create(
            @Valid @RequestBody DepartmentRequestDto requestDto) {
        return ResponseEntity.ok(departmentService.create(requestDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<DepartmentResponseDto> updateById(
            @Valid @RequestBody DepartmentRequestDto requestDto,
            @PathVariable Long id) {
        return ResponseEntity.ok(departmentService.update(id, requestDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable Long id) {
        departmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

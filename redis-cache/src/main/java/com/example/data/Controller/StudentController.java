package com.example.data.Controller;

import com.example.data.Controller.dto.request.StudentRequestDto;
import com.example.data.Controller.dto.response.StudentResponseDto;
import com.example.data.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping(value = "api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("list")
    public ResponseEntity<List<StudentResponseDto>> getAll() {
        return ResponseEntity.ok(studentService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<StudentResponseDto> getById(
            @PathVariable Long id) {
        return ResponseEntity.ok(studentService.getById(id));
    }

    @GetMapping("count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(studentService.countActive());
    }

    @PostMapping
    public ResponseEntity<StudentResponseDto> create(
            @Valid @RequestBody StudentRequestDto requestDto) {
        return ResponseEntity.ok(studentService.create(requestDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<StudentResponseDto> updateById(
            @Valid @RequestBody StudentRequestDto requestDto,
            @PathVariable Long id) {
        return ResponseEntity.ok(studentService.update(id, requestDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable Long id) {
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

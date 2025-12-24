package com.example.data.Controller;

import com.example.data.Controller.dto.request.CourseRequestDto;
import com.example.data.Controller.dto.response.CourseResponseDto;
import com.example.data.service.CourseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping(value = "api/v1/course")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("list")
    public ResponseEntity<List<CourseResponseDto>> getAll() {
        return ResponseEntity.ok(courseService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<CourseResponseDto> getById(
            @PathVariable Long id) {
        return ResponseEntity.ok(courseService.getById(id));
    }

    @GetMapping("count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(courseService.countActive());
    }

    @PostMapping
    public ResponseEntity<CourseResponseDto> create(
            @Valid @RequestBody CourseRequestDto requestDto) {
        return ResponseEntity.ok(courseService.create(requestDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<CourseResponseDto> updateById(
            @Valid @RequestBody CourseRequestDto requestDto,
            @PathVariable Long id) {
        return ResponseEntity.ok(courseService.update(id, requestDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable Long id) {
        courseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

package com.example.data.Controller;

import com.example.data.Controller.dto.request.EnrollmentRequestDto;
import com.example.data.Controller.dto.response.EnrollmentResponseDto;
import com.example.data.service.EnrollmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping(value = "api/v1/enrollment")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @GetMapping("list")
    public ResponseEntity<List<EnrollmentResponseDto>> getAll() {
        return ResponseEntity.ok(enrollmentService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<EnrollmentResponseDto> getById(
            @PathVariable Long id) {
        return ResponseEntity.ok(enrollmentService.getById(id));
    }

    @GetMapping("count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(enrollmentService.countActive());
    }

    @PostMapping
    public ResponseEntity<EnrollmentResponseDto> create(
            @Valid @RequestBody EnrollmentRequestDto requestDto) {
        return ResponseEntity.ok(enrollmentService.create(requestDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<EnrollmentResponseDto> updateById(
            @Valid @RequestBody EnrollmentRequestDto requestDto,
            @PathVariable Long id) {
        return ResponseEntity.ok(enrollmentService.update(id, requestDto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable Long id) {
        enrollmentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

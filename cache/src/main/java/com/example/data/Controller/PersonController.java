package com.example.data.Controller;

import com.example.data.Controller.dto.request.PersonRequestDto;
import com.example.data.Controller.dto.response.PersonResponseDto;
import com.example.data.service.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Validated
@RestController
@RequestMapping(value = "api/v1/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @GetMapping("list")
    public ResponseEntity<List<PersonResponseDto>> getAllPersons() {
        return ResponseEntity.ok(personService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<PersonResponseDto> getPersonById(
            @PathVariable UUID id) {
        return ResponseEntity.ok(personService.getById(id));
    }

    @GetMapping("count")
    public ResponseEntity<Long> countPeople() {
        return ResponseEntity.ok(personService.count());
    }

    @PostMapping
    public ResponseEntity<PersonResponseDto> createPerson(
            @Valid @RequestBody PersonRequestDto requestDto) {
        return ResponseEntity.ok(personService.create(requestDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<PersonResponseDto> createPerson(
            @Valid @RequestBody PersonRequestDto requestDto,
            @PathVariable UUID id) {
        return ResponseEntity.ok(personService.update(requestDto, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePersonById(
            @PathVariable UUID id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

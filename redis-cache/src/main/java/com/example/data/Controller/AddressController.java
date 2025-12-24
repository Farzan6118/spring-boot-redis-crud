package com.example.data.Controller;

import com.example.data.Controller.dto.request.AddressRequestDto;
import com.example.data.Controller.dto.response.AddressResponseDto;
import com.example.data.service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping(value = "api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping("list")
    public ResponseEntity<List<AddressResponseDto>> getAll() {
        return ResponseEntity.ok(addressService.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<AddressResponseDto> getById(
            @PathVariable Long id) {
        return ResponseEntity.ok(addressService.getById(id));
    }

    @GetMapping("count")
    public ResponseEntity<Long> count() {
        return ResponseEntity.ok(addressService.countActive());
    }

    @PostMapping
    public ResponseEntity<AddressResponseDto> create(
            @Valid @RequestBody AddressRequestDto requestDto) {
        return ResponseEntity.ok(addressService.create(requestDto));
    }

    @PutMapping("{id}")
    public ResponseEntity<AddressResponseDto> updateById(
            @Valid @RequestBody AddressRequestDto requestDto,
            @PathVariable Long id) {
        return ResponseEntity.ok(addressService.update(requestDto, id));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(
            @PathVariable Long id) {
        addressService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

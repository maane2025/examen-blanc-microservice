package com.example.keynoteservice.controller;

import com.example.keynoteservice.dto.KeynoteDTO;
import com.example.keynoteservice.service.KeynoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/keynotes")
@RequiredArgsConstructor
@Tag(name = "Keynote Management", description = "APIs for managing keynotes")
public class KeynoteController {

    private final KeynoteService keynoteService;

    @GetMapping
    @Operation(summary = "Get all keynotes")
    public ResponseEntity<List<KeynoteDTO>> getAllKeynotes() {
        List<KeynoteDTO> keynotes = keynoteService.getAllKeynotes();
        return ResponseEntity.ok(keynotes);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get keynote by ID")
    public ResponseEntity<KeynoteDTO> getKeynoteById(@PathVariable Long id) {
        KeynoteDTO keynote = keynoteService.getKeynoteById(id);
        return ResponseEntity.ok(keynote);
    }

    @PostMapping
    @Operation(summary = "Create a new keynote")
    public ResponseEntity<KeynoteDTO> createKeynote(@RequestBody KeynoteDTO keynoteDTO) {
        KeynoteDTO createdKeynote = keynoteService.createKeynote(keynoteDTO);
        return ResponseEntity.ok(createdKeynote);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing keynote")
    public ResponseEntity<KeynoteDTO> updateKeynote(@PathVariable Long id, @RequestBody KeynoteDTO keynoteDTO) {
        KeynoteDTO updatedKeynote = keynoteService.updateKeynote(id, keynoteDTO);
        return ResponseEntity.ok(updatedKeynote);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a keynote")
    public ResponseEntity<Void> deleteKeynote(@PathVariable Long id) {
        keynoteService.deleteKeynote(id);
        return ResponseEntity.noContent().build();
    }
}
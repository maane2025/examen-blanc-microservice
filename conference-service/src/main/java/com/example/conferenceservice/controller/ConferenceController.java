package com.example.conferenceservice.controller;

import com.example.conferenceservice.dto.ConferenceDTO;
import com.example.conferenceservice.dto.ReviewDTO;
import com.example.conferenceservice.service.ConferenceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/conferences")
@RequiredArgsConstructor
@Tag(name = "Conference Management", description = "APIs for managing conferences and reviews")
public class ConferenceController {

    private final ConferenceService conferenceService;

    @GetMapping
    @Operation(summary = "Get all conferences")
    public ResponseEntity<List<ConferenceDTO>> getAllConferences() {
        List<ConferenceDTO> conferences = conferenceService.getAllConferences();
        return ResponseEntity.ok(conferences);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get conference by ID")
    public ResponseEntity<ConferenceDTO> getConferenceById(@PathVariable Long id) {
        ConferenceDTO conference = conferenceService.getConferenceById(id);
        return ResponseEntity.ok(conference);
    }

    @PostMapping
    @Operation(summary = "Create a new conference")
    public ResponseEntity<ConferenceDTO> createConference(@RequestBody ConferenceDTO conferenceDTO) {
        ConferenceDTO createdConference = conferenceService.createConference(conferenceDTO);
        return ResponseEntity.ok(createdConference);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing conference")
    public ResponseEntity<ConferenceDTO> updateConference(@PathVariable Long id, @RequestBody ConferenceDTO conferenceDTO) {
        ConferenceDTO updatedConference = conferenceService.updateConference(id, conferenceDTO);
        return ResponseEntity.ok(updatedConference);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a conference")
    public ResponseEntity<Void> deleteConference(@PathVariable Long id) {
        conferenceService.deleteConference(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/reviews")
    @Operation(summary = "Add a review to a conference")
    public ResponseEntity<ReviewDTO> addReview(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO) {
        ReviewDTO createdReview = conferenceService.addReviewToConference(id, reviewDTO);
        return ResponseEntity.ok(createdReview);
    }

    @GetMapping("/{id}/reviews")
    @Operation(summary = "Get all reviews for a conference")
    public ResponseEntity<List<ReviewDTO>> getReviews(@PathVariable Long id) {
        List<ReviewDTO> reviews = conferenceService.getReviewsForConference(id);
        return ResponseEntity.ok(reviews);
    }
}
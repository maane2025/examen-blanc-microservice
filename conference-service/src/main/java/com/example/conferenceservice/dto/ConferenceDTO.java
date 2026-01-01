package com.example.conferenceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConferenceDTO {
    private Long id;
    private String title;
    private String type; // Academic or Commercial
    private LocalDate date;
    private Integer duration; // in minutes
    private Integer registeredCount;
    private Double score;
    private List<ReviewDTO> reviews;
}
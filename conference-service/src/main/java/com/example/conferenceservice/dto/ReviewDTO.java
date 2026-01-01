package com.example.conferenceservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO {
    private Long id;
    private LocalDate date;
    private String text;
    private Integer stars; // 1 to 5
}
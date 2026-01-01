package com.example.conferenceservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Conference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String type; // Academic or Commercial
    private LocalDate date;
    private Integer duration; // in minutes
    private Integer registeredCount;
    private Double score;

    @OneToMany(mappedBy = "conference", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Review> reviews;
}
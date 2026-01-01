package com.example.conferenceservice.mapper;

import com.example.conferenceservice.dto.ConferenceDTO;
import com.example.conferenceservice.dto.ReviewDTO;
import com.example.conferenceservice.entity.Conference;
import com.example.conferenceservice.entity.Review;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ConferenceMapper {

    public ConferenceDTO toDTO(Conference conference) {
        if (conference == null) {
            return null;
        }
        ConferenceDTO dto = new ConferenceDTO();
        dto.setId(conference.getId());
        dto.setTitle(conference.getTitle());
        dto.setType(conference.getType());
        dto.setDate(conference.getDate());
        dto.setDuration(conference.getDuration());
        dto.setRegisteredCount(conference.getRegisteredCount());
        dto.setScore(conference.getScore());
        if (conference.getReviews() != null) {
            dto.setReviews(conference.getReviews().stream()
                    .map(this::reviewToDTO)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public Conference toEntity(ConferenceDTO dto) {
        if (dto == null) {
            return null;
        }
        Conference conference = new Conference();
        conference.setId(dto.getId());
        conference.setTitle(dto.getTitle());
        conference.setType(dto.getType());
        conference.setDate(dto.getDate());
        conference.setDuration(dto.getDuration());
        conference.setRegisteredCount(dto.getRegisteredCount());
        conference.setScore(dto.getScore());
        if (dto.getReviews() != null) {
            conference.setReviews(dto.getReviews().stream()
                    .map(this::reviewToEntity)
                    .collect(Collectors.toList()));
        }
        return conference;
    }

    private ReviewDTO reviewToDTO(Review review) {
        if (review == null) {
            return null;
        }
        ReviewDTO dto = new ReviewDTO();
        dto.setId(review.getId());
        dto.setDate(review.getDate());
        dto.setText(review.getText());
        dto.setStars(review.getStars());
        return dto;
    }

    private Review reviewToEntity(ReviewDTO dto) {
        if (dto == null) {
            return null;
        }
        Review review = new Review();
        review.setId(dto.getId());
        review.setDate(dto.getDate());
        review.setText(dto.getText());
        review.setStars(dto.getStars());
        return review;
    }
}
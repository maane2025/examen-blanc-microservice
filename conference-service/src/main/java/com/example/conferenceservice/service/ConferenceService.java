package com.example.conferenceservice.service;

import com.example.conferenceservice.dto.ConferenceDTO;
import com.example.conferenceservice.dto.ReviewDTO;
import com.example.conferenceservice.entity.Conference;
import com.example.conferenceservice.entity.Review;
import com.example.conferenceservice.mapper.ConferenceMapper;
import com.example.conferenceservice.repository.ConferenceRepository;
import com.example.conferenceservice.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ConferenceService {

    private final ConferenceRepository conferenceRepository;
    private final ReviewRepository reviewRepository;
    private final ConferenceMapper conferenceMapper;

    public List<ConferenceDTO> getAllConferences() {
        return conferenceRepository.findAll().stream()
                .map(conferenceMapper::toDTO)
                .collect(Collectors.toList());
    }

    public ConferenceDTO getConferenceById(Long id) {
        Conference conference = conferenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conference not found"));
        return conferenceMapper.toDTO(conference);
    }

    public ConferenceDTO createConference(ConferenceDTO conferenceDTO) {
        Conference conference = conferenceMapper.toEntity(conferenceDTO);
        Conference savedConference = conferenceRepository.save(conference);
        return conferenceMapper.toDTO(savedConference);
    }

    public ConferenceDTO updateConference(Long id, ConferenceDTO conferenceDTO) {
        Conference existingConference = conferenceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Conference not found"));
        existingConference.setTitle(conferenceDTO.getTitle());
        existingConference.setType(conferenceDTO.getType());
        existingConference.setDate(conferenceDTO.getDate());
        existingConference.setDuration(conferenceDTO.getDuration());
        existingConference.setRegisteredCount(conferenceDTO.getRegisteredCount());
        existingConference.setScore(conferenceDTO.getScore());
        Conference updatedConference = conferenceRepository.save(existingConference);
        return conferenceMapper.toDTO(updatedConference);
    }

    public void deleteConference(Long id) {
        conferenceRepository.deleteById(id);
    }

    public ReviewDTO addReviewToConference(Long conferenceId, ReviewDTO reviewDTO) {
        Conference conference = conferenceRepository.findById(conferenceId)
                .orElseThrow(() -> new RuntimeException("Conference not found"));

        Review review = new Review();
        review.setDate(reviewDTO.getDate() != null ? reviewDTO.getDate() : LocalDate.now());
        review.setText(reviewDTO.getText());
        review.setStars(reviewDTO.getStars());
        review.setConference(conference);

        Review savedReview = reviewRepository.save(review);
        reviewDTO.setId(savedReview.getId());
        return reviewDTO;
    }

    public List<ReviewDTO> getReviewsForConference(Long conferenceId) {
        Conference conference = conferenceRepository.findById(conferenceId)
                .orElseThrow(() -> new RuntimeException("Conference not found"));
        return conference.getReviews().stream()
                .map(review -> {
                    ReviewDTO dto = new ReviewDTO();
                    dto.setId(review.getId());
                    dto.setDate(review.getDate());
                    dto.setText(review.getText());
                    dto.setStars(review.getStars());
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
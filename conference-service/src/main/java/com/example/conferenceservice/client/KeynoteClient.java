package com.example.conferenceservice.client;

import com.example.conferenceservice.dto.KeynoteDTO;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "keynote-service")
public interface KeynoteClient {

    @GetMapping("/api/keynotes")
    @CircuitBreaker(name = "keynote-service", fallbackMethod = "getAllKeynotesFallback")
    List<KeynoteDTO> getAllKeynotes();

    @GetMapping("/api/keynotes/{id}")
    @CircuitBreaker(name = "keynote-service", fallbackMethod = "getKeynoteByIdFallback")
    KeynoteDTO getKeynoteById(@PathVariable("id") Long id);

    default List<KeynoteDTO> getAllKeynotesFallback(Exception e) {
        // Return empty list or cached data
        return List.of();
    }

    default KeynoteDTO getKeynoteByIdFallback(Long id, Exception e) {
        // Return null or default keynote
        return null;
    }
}
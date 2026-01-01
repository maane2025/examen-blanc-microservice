package com.example.keynoteservice.service;

import com.example.keynoteservice.dto.KeynoteDTO;
import com.example.keynoteservice.entity.Keynote;
import com.example.keynoteservice.mapper.KeynoteMapper;
import com.example.keynoteservice.repository.KeynoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KeynoteService {

    private final KeynoteRepository keynoteRepository;
    private final KeynoteMapper keynoteMapper;

    public List<KeynoteDTO> getAllKeynotes() {
        return keynoteRepository.findAll().stream()
                .map(keynoteMapper::toDTO)
                .collect(Collectors.toList());
    }

    public KeynoteDTO getKeynoteById(Long id) {
        Keynote keynote = keynoteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Keynote not found"));
        return keynoteMapper.toDTO(keynote);
    }

    public KeynoteDTO createKeynote(KeynoteDTO keynoteDTO) {
        Keynote keynote = keynoteMapper.toEntity(keynoteDTO);
        Keynote savedKeynote = keynoteRepository.save(keynote);
        return keynoteMapper.toDTO(savedKeynote);
    }

    public KeynoteDTO updateKeynote(Long id, KeynoteDTO keynoteDTO) {
        Keynote existingKeynote = keynoteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Keynote not found"));
        existingKeynote.setName(keynoteDTO.getName());
        existingKeynote.setFirstName(keynoteDTO.getFirstName());
        existingKeynote.setEmail(keynoteDTO.getEmail());
        existingKeynote.setFunction(keynoteDTO.getFunction());
        Keynote updatedKeynote = keynoteRepository.save(existingKeynote);
        return keynoteMapper.toDTO(updatedKeynote);
    }

    public void deleteKeynote(Long id) {
        keynoteRepository.deleteById(id);
    }
}
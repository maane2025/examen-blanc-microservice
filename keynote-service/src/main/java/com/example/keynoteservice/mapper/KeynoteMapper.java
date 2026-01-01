package com.example.keynoteservice.mapper;

import com.example.keynoteservice.dto.KeynoteDTO;
import com.example.keynoteservice.entity.Keynote;
import org.springframework.stereotype.Component;

@Component
public class KeynoteMapper {

    public KeynoteDTO toDTO(Keynote keynote) {
        if (keynote == null) {
            return null;
        }
        KeynoteDTO dto = new KeynoteDTO();
        dto.setId(keynote.getId());
        dto.setName(keynote.getName());
        dto.setFirstName(keynote.getFirstName());
        dto.setEmail(keynote.getEmail());
        dto.setFunction(keynote.getFunction());
        return dto;
    }

    public Keynote toEntity(KeynoteDTO dto) {
        if (dto == null) {
            return null;
        }
        Keynote keynote = new Keynote();
        keynote.setId(dto.getId());
        keynote.setName(dto.getName());
        keynote.setFirstName(dto.getFirstName());
        keynote.setEmail(dto.getEmail());
        keynote.setFunction(dto.getFunction());
        return keynote;
    }
}
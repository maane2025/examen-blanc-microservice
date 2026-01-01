package com.example.keynoteservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeynoteDTO {
    private Long id;
    private String name;
    private String firstName;
    private String email;
    private String function;
}
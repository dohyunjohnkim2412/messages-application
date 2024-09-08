package com.example.messages.message.dto;


import java.time.LocalDate;
public record MessageResponseDTO(Long id, String content, LocalDate createdOn) {
}

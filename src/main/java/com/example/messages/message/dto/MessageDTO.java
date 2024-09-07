package com.example.messages.message.dto;


import java.time.LocalDate;
public record MessageDTO(Long id, String content, LocalDate createdOn) {
}

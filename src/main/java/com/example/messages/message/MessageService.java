package com.example.messages.message;

import com.example.messages.message.dto.MessageCreationDTO;
import com.example.messages.message.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    private MessageDTO convertToDTO(Message message) {
        return new MessageDTO(message.getId(), message.getContent(), message.getCreatedOn());
    }

    public List<MessageDTO> getAllMessages() {
        return messageRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public void createMessage(MessageCreationDTO messageCreationDTO) {
        Message message = new Message();
        message.setContent(messageCreationDTO.content());
        message.setCreatedOn(LocalDate.now());
        messageRepository.save(message);
    }

}

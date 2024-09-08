package com.example.messages.message;

import com.example.messages.message.dto.MessageRequestDTO;
import com.example.messages.message.dto.MessageResponseDTO;
import com.example.messages.message.errors.MessageNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    // Convert Message to MessageDTO
    private MessageResponseDTO convertToDTO(Message message) {
        return new MessageResponseDTO(message.getId(), message.getContent(), message.getCreatedOn());
    }

    // Get all messages
    public List<MessageResponseDTO> getAllMessages(int top, String sort) {
        Pageable paging = PageRequest.of(0, top, Sort.by(sort));
        return messageRepository.findAll(paging).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Get message by id
    public MessageResponseDTO getMessageById(Long id) {
        return messageRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new MessageNotFoundException(id));
    }

    // Create a new message
    public MessageResponseDTO createMessage(MessageRequestDTO messageRequestDTO) {
        Message message = new Message(messageRequestDTO.content());
        messageRepository.save(message);
        return convertToDTO(message);

    }

    // Update a message
    public MessageResponseDTO updateMessage(Long id, MessageRequestDTO messageRequestDTO) {
        Message message = messageRepository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException(id));
        message.setContent(messageRequestDTO.content());
        messageRepository.save(message);
        return convertToDTO(message);
    }

    // Delete a message
    public void deleteMessage(Long id) {
        Message message = messageRepository.findById(id)
                .orElseThrow(() -> new MessageNotFoundException(id));
        messageRepository.delete(message);
    }
}

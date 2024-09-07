package com.example.messages.message;

import com.example.messages.message.dto.MessageContentDTO;
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

    public void createMessage(MessageContentDTO messageCreationDTO) {
        Message message = new Message();
        message.setContent(messageCreationDTO.content());
        message.setCreatedOn(LocalDate.now());
        messageRepository.save(message);
    }

    public MessageDTO getMessageById(Long id) {
        return messageRepository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new IllegalArgumentException("Message not found"));
    }

    public void updateMessage(Long id, MessageContentDTO messageContentDTO) {
        Message message = messageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Message not found"));
        message.setContent(messageContentDTO.content());
        messageRepository.save(message);
    }

    public void deleteMessage(Long id) {
        messageRepository.deleteById(id);
    }
}

package com.example.messages.message;

import com.example.messages.message.dto.MessageRequestDTO;
import com.example.messages.message.dto.MessageResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    // Get all messages
    @GetMapping("/messages")
    public List<MessageResponseDTO> getAllMessages() {
        return messageService.getAllMessages();
    }

    // Get message by id
    @GetMapping("messages/{id}")
    public MessageResponseDTO getMessageById(@PathVariable Long id) {
        return messageService.getMessageById(id);
    }

    // Create a new message
    @PostMapping("/messages")
    public MessageResponseDTO createMessage(@RequestBody MessageRequestDTO messageRequestDTO) {
        return messageService.createMessage(messageRequestDTO);
    }

    // Update a message
    @PutMapping("messages/{id}")
    public MessageResponseDTO updateMessage(@PathVariable Long id, @RequestBody MessageRequestDTO messageRequestDTO) {

        return messageService.updateMessage(id, messageRequestDTO);
    }

    // Delete a message
    @DeleteMapping("messages/{id}")
    public void deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
    }
}

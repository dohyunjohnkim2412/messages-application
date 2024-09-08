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
    public String createMessage(@RequestBody MessageRequestDTO messageRequestDTO) {
        messageService.createMessage(messageRequestDTO);
        return "Message created";
    }

    // Update a message
    @PutMapping("messages/{id}")
    public String updateMessage(@PathVariable Long id, @RequestBody MessageRequestDTO messageRequestDTO) {
        messageService.updateMessage(id, messageRequestDTO);
        return "Message updated";
    }

    // Delete a message
    @DeleteMapping("messages/{id}")
    public String deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
        return "Message deleted";
    }
}

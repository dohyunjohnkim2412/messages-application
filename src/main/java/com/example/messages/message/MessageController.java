package com.example.messages.message;

import com.example.messages.message.dto.MessageContentDTO;
import com.example.messages.message.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping("/messages")
    public List<MessageDTO> getAllMessages() {
        return messageService.getAllMessages();
    }

    @PostMapping("/messages")
    public String createMessage(@RequestBody MessageContentDTO messageContentDTO) {
        messageService.createMessage(messageContentDTO);
        return "Message created";
    }
    @GetMapping("messages/{id}")
    public MessageDTO getMessageById(@PathVariable Long id) {
        return messageService.getMessageById(id);
    }
    @PutMapping("messages/{id}")
    public String updateMessage(@PathVariable Long id, @RequestBody MessageContentDTO messageContentDTO) {
        messageService.updateMessage(id, messageContentDTO);
        return "Message updated";
    }
    @DeleteMapping("messages/{id}")
    public String deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
        return "Message deleted";
    }
}

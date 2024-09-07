package com.example.messages.message;

import com.example.messages.message.dto.MessageCreationDTO;
import com.example.messages.message.dto.MessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public String createMessage(@RequestBody MessageCreationDTO messageCreationDTO) {
        messageService.createMessage(messageCreationDTO);
        return "Message created";
    }

}

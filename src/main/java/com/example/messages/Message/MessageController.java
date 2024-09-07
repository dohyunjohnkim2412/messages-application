package com.example.messages.Message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping("/messages")
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }

}

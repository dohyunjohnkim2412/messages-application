package com.example.messages.message.errors;

public class MessageNotFoundException extends RuntimeException{
    public MessageNotFoundException(Long id) {
        super("Could not find message with id: " + id);
    }
}

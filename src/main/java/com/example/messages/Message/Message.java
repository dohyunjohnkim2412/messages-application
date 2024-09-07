package com.example.messages.Message;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "messages")
public class Message {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "created_on")
    private LocalDate createdOn;

    public Message() {
    }

    public Message(String content) {
        this.content = content;
    }

    public Message(Long id, String content, LocalDate createdOn) {
        this.id = id;
        this.content = content;
        this.createdOn = createdOn;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createdOn=" + createdOn +
                '}';
    }
}

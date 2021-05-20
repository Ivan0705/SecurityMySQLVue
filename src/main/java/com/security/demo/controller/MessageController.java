package com.security.demo.controller;
import com.security.demo.domain.Message;

import com.security.demo.repository.MessageRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class MessageController {
    private final MessageRepo messageRepo;

    @Autowired
    public MessageController(MessageRepo messageRepo) {
        this.messageRepo = messageRepo;
    }

    @GetMapping("/message")
    public List<Message> list() {
        return messageRepo.findAll();
    }

    @GetMapping("/message/{id}")
    public Message getOne(@PathVariable("id") Message message) {
        return message;
    }


    @PostMapping("/message")
    public Message create(@RequestBody Message message) {
        message.setCreateData(LocalDateTime.now());
        return messageRepo.save(message);
    }

    @PutMapping("/message/{id}")
    public Message update(@PathVariable("id") Message messageFromDb,
                          @RequestBody Message message) {

        BeanUtils.copyProperties(message, messageFromDb, "id");
        return messageRepo.save(messageFromDb);
    }

    @DeleteMapping("/message/{id}")
    public void delete(@PathVariable("id") Message message) {
        messageRepo.delete(message);
    }

    @MessageMapping("/changeMessage")
    @SendTo("/topic/activity")
    public Message change(Message message) {
        return messageRepo.save(message);

    }
}

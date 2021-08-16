package com.example.messageserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.format.WebConversionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class MessageController {

    @PostMapping("/messages")
    public ResponseEntity<Message> createNewMessage(@Valid @RequestBody Message message) {
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

}

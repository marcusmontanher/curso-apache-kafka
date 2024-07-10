package com.marcusmontanher.strproducer.resources;

import com.marcusmontanher.strproducer.services.StringProducerServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/producer")
public class StringProducerResource {

    private final StringProducerServices producerService;

    @PostMapping
    public ResponseEntity<?> sendMessagge(@RequestBody String message) {
        producerService.sendMessage(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

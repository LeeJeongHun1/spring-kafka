package com.kafka.springkafka.controller;

import com.kafka.springkafka.service.KafkaProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/kafka")
public class KafkaController {
    private final KafkaProducer kafkaProducer;

    @PostMapping
    @ResponseBody
    public String sendMessage(@RequestBody String message) {
        log.info("message : {}", message);
        this.kafkaProducer.sendMessage(message);

        return "success";
    }
}

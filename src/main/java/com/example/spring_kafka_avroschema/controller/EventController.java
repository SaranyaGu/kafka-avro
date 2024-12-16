package com.example.spring_kafka_avroschema.controller;

import com.example.spring_kafka_avroschema.dto.Employee;
import com.example.spring_kafka_avroschema.producer.KafkaAvroProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventController {

    @Autowired
    private KafkaAvroProducer producer;

    @PostMapping("/employees")
    public ResponseEntity<String> sendEmployeeMessage(@RequestBody Employee employee) {
        producer.send(employee);
        return ResponseEntity.ok("Message published successfully");
    }
}

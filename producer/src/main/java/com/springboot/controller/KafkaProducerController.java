package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.Student;
import com.springboot.service.KafkaSender;

@RestController
@RequestMapping("/kafkaProducer")
public class KafkaProducerController {

	@Autowired
	private KafkaSender sender;
	
	@PostMapping(consumes = "application/json")
	public ResponseEntity<String> sendData(@RequestBody Student student){
		System.out.println("student.getStudentId() = " + student.getStudentId());
		sender.sendData(student);
		return new ResponseEntity<>("Data sent to Kafka", HttpStatus.OK);
	}
}

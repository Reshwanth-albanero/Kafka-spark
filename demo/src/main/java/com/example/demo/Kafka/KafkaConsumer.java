package com.example.demo.Kafka;

import com.example.demo.Model.User;
import com.example.demo.Repository.CsvFile;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.kafka.annotation.KafkaListener;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
@Service
public class KafkaConsumer {

    Logger logger = LoggerFactory.getLogger(KafkaConsumer.class);
    @Autowired
    CsvFile csvFile;
    @KafkaListener(topics = "demo", groupId = "myGroup")
    public void consume(String message){
        String [] words = message.split(",");
        csvFile.save(new User(words[0],words[1],words[2]));

    }
}
package com.example.demo.Spliting;

import com.example.demo.Kafka.KafkaProducer;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class CsvSplitting {
    public String split(String path,KafkaProducer kafkaProducer) throws IOException {
        Path filename = Path.of(path);
        String text = Files.readString(filename);
        String [] lines = text.split("\n");
        for(String line: lines){
            kafkaProducer.sendMessage(line);
        }
        return "Success";
    }

}

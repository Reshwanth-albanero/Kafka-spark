package com.example.demo.Controller;

import com.example.demo.Kafka.KafkaProducer;
import com.example.demo.Model.User;
import com.example.demo.Repository.CsvFile;
import com.example.demo.Spliting.CsvSplitting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
public class CsvController {

    private KafkaProducer kafkaProducer;
    public CsvController(KafkaProducer kafkaProducer){
        this.kafkaProducer = kafkaProducer;
    }

    @Autowired
    CsvFile csvFile;
    @PostMapping()
    public String upload(@RequestParam("file")MultipartFile multipartFile) throws IOException {
        multipartFile.transferTo(new File("/home/albanero/Downloads/19-04-2023(2)/demo/src/main/resources/Test"));
        return (new CsvSplitting()).split("/home/albanero/Downloads/19-04-2023(2)/demo/src/main/resources/Test",kafkaProducer);
    }
//    @PostMapping()
//    public String update(@RequestParam("message") String message){
//        kafkaProducer.sendMessage(message);
//        return "Success";
//    }
    @GetMapping()
    public List<User> get(){
        return csvFile.findAll();
    }
}

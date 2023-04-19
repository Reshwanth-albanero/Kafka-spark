package com.example.demo.ConfigTopic;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class Topic {
    @Bean
    public NewTopic javaguidesTopic(){
        return TopicBuilder.name("demo")
                .build();
    }

}

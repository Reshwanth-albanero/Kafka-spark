package com.example.demo.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "User")
public class User {
    @Id
    private String _id;
    private String id;
    private String name;
    private String address;
    public User(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}

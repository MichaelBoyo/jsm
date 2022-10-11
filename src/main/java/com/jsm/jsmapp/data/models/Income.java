package com.jsm.jsmapp.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.annotation.security.DenyAll;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Income {
    @Id
    private String id;
    private Double amount;
    private String date;
    private String category;
    private String postedBy;
    private String description;
}

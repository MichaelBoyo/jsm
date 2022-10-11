package com.jsm.jsmapp.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Expense {
    private String id;
    private Double amount;
    private String date;
    private String category;
    private String postedBy;
    private String description;
}

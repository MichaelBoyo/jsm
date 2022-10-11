package com.jsm.jsmapp.data.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddIncomeRequest {
    private Double amount;
    private String category;
    private String postedBy;
    private String description;
}

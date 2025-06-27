package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Expense {
    private Integer id;
    private Integer userId;
    private LocalDate date;
    private String reason;
    private String category;
    private Double amount;
    private LocalDateTime createdAt;
}

package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class Income {

	private Integer id;
    private Integer userId;
    private LocalDate date;
    private String source;
    private String category;
    private BigDecimal amount;
    private LocalDateTime createdAt;
}

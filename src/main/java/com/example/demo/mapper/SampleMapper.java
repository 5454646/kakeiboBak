package com.example.demo.mapper;

import java.time.LocalDate;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Expense;
import com.example.demo.entity.Income;
import com.example.demo.entity.TestScore;

@Mapper
public interface SampleMapper {
    List<TestScore> select();
    
    void insertExpense(Expense expense);
    
    void insertIncome(Income income);
    
    List<Expense> findByDateRange(@Param("from") LocalDate from, @Param("to") LocalDate to);
    
    List<Income> findByDateIncomeRange(@Param("from") LocalDate from, @Param("to") LocalDate to);
    
    int getExpenssesAllAmount();
    
    int getIncomesAllAmount();
    
    void deleteExpenses(Long id);
    
    void deleteIncomes(Long id);
}


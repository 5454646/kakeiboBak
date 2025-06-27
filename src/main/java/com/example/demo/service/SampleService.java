package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Expense;
import com.example.demo.entity.Income;
import com.example.demo.entity.TestScore;
import com.example.demo.mapper.SampleMapper;

@Service
public class SampleService {
	
	@Autowired
    private SampleMapper sampleMapper;


    public List<Expense> getExpensesInRange(LocalDate from, LocalDate to) {
    	 List<Expense> date = sampleMapper.findByDateRange(from, to);
    	 System.out.println(date);
        return sampleMapper.findByDateRange(from, to);
    }
    
    public List<Income> getIncomeInRange(LocalDate from, LocalDate to) {
   	 List<Income> date = sampleMapper.findByDateIncomeRange(from, to);
   	 System.out.println(date);
       return sampleMapper.findByDateIncomeRange(from, to);
   }
    
    public List<TestScore> getScores(){
    	return sampleMapper.select();
    }

    public void addExpense(Expense expense) {
    	 sampleMapper.insertExpense(expense);
    }
    
    public void addIncomes(Income income) {
    	sampleMapper.insertIncome(income);
    }
    
    public int getExpensesAllAmount() {
    	return sampleMapper.getExpenssesAllAmount();
    }
    
    public int getIncomesAllAmount() {
    	return sampleMapper.getIncomesAllAmount();
    }
    
    public void deleteExpenses(Long id) {
    	 sampleMapper.deleteExpenses(id);
    }
    
    public void deleteIncomes(Long id) {
    	 sampleMapper.deleteIncomes(id);
    }
}

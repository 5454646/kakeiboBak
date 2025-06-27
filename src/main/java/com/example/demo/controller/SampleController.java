package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BirthStone;
import com.example.demo.entity.Expense;
import com.example.demo.entity.Income;
import com.example.demo.entity.TestScore;
import com.example.demo.service.SampleService;

@RestController
@CrossOrigin(origins = "*") 
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @GetMapping("/")
    public List<TestScore> getScores() {
        return sampleService.getScores();
    }
    
    @GetMapping("/api")
    @ResponseBody
    public BirthStone getBirthStone() {
        BirthStone birthStone = new BirthStone();
        birthStone.setMonth("2月");
        birthStone.setName("アメジスト");
        birthStone.setColor("紫");
        return birthStone;
    }
    
    @PostMapping("/api/expenses")
    public void addExpense(@RequestBody Expense expense) {
        // userIdが必須なのでチェックする場合は以下のようにする
    	if (expense.getUserId() == null) {
            expense.setUserId(1); // 一時的に固定
        }
    	System.out.println("支出を登録しました");
    	sampleService.addExpense(expense);
    }
    
    @PostMapping("/api/incomes")
    public void addIncomes(@RequestBody Income income) {
        // userIdが必須なのでチェックする場合は以下のようにする
    	if (income.getUserId() == null) {
    		income.setUserId(1); // 一時的に固定
        }
    	System.out.println("収入を登録しました");
    	sampleService.addIncomes(income);
    }
    
    @GetMapping("/api/expenses")
    public List<Expense> getExpenses(
            @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
    	System.out.println("支出を取得しに来ました");

            return sampleService.getExpensesInRange(from, to);
        }
    
    @GetMapping("/api/incomes")
    public List<Income> getIncome(
            @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to) {
    	System.out.println("収入を取得しに来ました");

            return sampleService.getIncomeInRange(from, to);
        }
    
    @GetMapping("/api/expenses/allAmount")
    public  Map<String,Integer> getExpensesAllAmount() {
    	System.out.println("支出合計");
    	int total = sampleService.getExpensesAllAmount();
    	return Map.of("total",total);
    }
    
    @GetMapping("/api/incomes/allAmount")
    public Map<String,Integer> getIncomesAllAmount() {
    	System.out.println("収入合計");
    	int total = sampleService.getIncomesAllAmount();
    	return Map.of("total",total);
    }
    
    @DeleteMapping("/api/expenses/{id}")
    public void deleteExpense(@PathVariable Long id) {
        sampleService.deleteExpenses(id);
    }

    @DeleteMapping("/api/incomes/{id}")
    public void deleteIncome(@PathVariable Long id) {
    	sampleService.deleteIncomes(id);
    }
}

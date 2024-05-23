package com.example.expense_tracker_application.service;

import com.example.expense_tracker_application.model.Expense;
import com.example.expense_tracker_application.repositroy.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService{

    @Autowired
    private ExpenseRepository expenseRepository;

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    @Override
    public Expense createExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    @Override
    public Expense updateExpense(Long id, Expense expense) {
        Expense existingExpense = expenseRepository.findById(id).orElse(null);
        if (existingExpense != null) {
            existingExpense.setAmount(expense.getAmount());
            existingExpense.setCategory(expense.getCategory());
            existingExpense.setDate(expense.getDate());
            existingExpense.setDescription(expense.getDescription());
            return expenseRepository.save(existingExpense);
        }
        return null;
    }

    @Override
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    // Custom Operation
    @Override
    public void updateExpenseAmount(Long id, Double amount){
        expenseRepository.updateExpenseAmount(id, amount);
    }

    @Override
    public void deleteByCategory(String category){
        expenseRepository.deleteByCategory(category);
    }

    @Override
    public void updateExpenseDescription(Long id, String description){
        expenseRepository.updateExpenseDescription(id, description);
    }

    @Override
    public void updateExpenseCategory(Long id, String category){
        expenseRepository.updateExpenseCategory(id, category);
    }

    @Override
    public void deleteByDateRange(LocalDate startDate, LocalDate endDate){
        expenseRepository.deleteByDateRange(startDate, endDate);
    }

    @Override
    public void updateExpenseDate(Long id, LocalDate date){
        expenseRepository.updateExpenseDate(id, date);
    }

    @Override
    public void updateExpenseUser(Long id, Long userId){
        expenseRepository.updateExpenseUser(id, userId);
    }

    @Override
    public void deleteByUser(Long userId){
        expenseRepository.deleteByUser(userId);
    }

    @Override
    public void updateMultipleExpenses(List<Long> ids, Double amount){
        expenseRepository.updateMultipleExpenses(ids, amount);
    }

    @Override
    public void deleteById(Long id){
        expenseRepository.deleteById(id);
    }



}
